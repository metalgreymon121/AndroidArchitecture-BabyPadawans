<?php

require_once '../include/user.php';

header('Content-Type: application/json');
$username = "";
$password = "";
$email = "";

if (isset($_POST['username'])) {
    $username = $_POST['username'];
} else {
    header('HTTP/1.1 400 Bad Request', true, 400);
    echo json_encode(array('code' => 400, 'message' => 'username param missing', 'response' => null));
}
if (isset($_POST['password'])) {
    $password = $_POST['password'];
} else {
    header('HTTP/1.1 400 Bad Request', true, 400);
    echo json_encode(array('code' => 400, 'message' => 'password param missing', 'response' => null));
}

if (isset($_POST['email'])) {
    $email = $_POST['email'];
} else {
    header('HTTP/1.1 400 Bad Request', true, 400);
    echo json_encode(array('code' => 400, 'message' => 'email param missing', 'response' => null));
}

// Instance of a User class
$userObject = new User();

// Registration of new user
if (!empty($username) && !empty($password) && !empty($email)) {
    $hashed_password = md5($password);
    if ($userObject->register($username, $hashed_password, $email)) {
        header('HTTP/1.1 201 Created', true, 201);
        echo json_encode(array('code' => 201, 'message' => 'You have registered successfully', 'response' => array('username' => $username, 'email' => $email)));
    } else {
        header('HTTP/1.1 500 Internal Server error', true, 500);
        echo json_encode(array('code' => 500, 'message' => 'Internal Server error', 'response' => array('error' => 'An error occurred during registration process')));
    }
}

$userObject = null;