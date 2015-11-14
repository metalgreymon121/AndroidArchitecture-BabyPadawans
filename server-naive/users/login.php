<?php

header('Content-Type: application/json');
require_once '../include/user.php';

$username = "";
$password = "";

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

// Instance of a User class
$userObject = new User();

// User Login
if (!empty($username) && !empty($password)) {
    $hashed_password = md5($password);
    $token = $userObject->signIn($username, $hashed_password);
    if ($token != null) {
        header('HTTP/1.1 200 OK', true, 200);
        echo json_encode(array('code' => 200, 'message' => 'You have logged in successfully', 'response' => array('username' => $username, 'token' => $token)));
    } else {
        header('HTTP/1.1 401 Unauthorized', true, 401);
        echo json_encode(array('code' => 401, 'message' => 'Your credentials are invalid', 'response' => null));
    }

}
$userObject = null;