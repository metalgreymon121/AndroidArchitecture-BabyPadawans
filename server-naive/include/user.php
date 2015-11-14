<?php

include_once 'db.php';

class User
{

    private $db;
    private $db_table = "users";

    public function __construct()
    {
        $this->db = new DbConnect();
    }

    /**
     * Checks if user credentials exist and they are valid
     * @param $username
     * @param $password
     * @return bool
     */
    public function isLoginExist($username, $password)
    {

        $query = "select * from " . $this->db_table . " where username = '$username' AND password = '$password' Limit 1";
        $result = mysqli_query($this->db->getDb(), $query);
        if (mysqli_num_rows($result) > 0) {
            return true;
        }
        return false;
    }

    /**
     * Checks if user exist
     * @param $username
     * @param $email
     * @return bool
     */
    public function isUserExist($username, $email)
    {
        $query = "select * from " . $this->db_table . " where username = '$username' AND email = '$email' Limit 1";
        $result = mysqli_query($this->db->getDb(), $query);
        if (mysqli_num_rows($result) > 0) {
            mysqli_close($this->db->getDb());
            return true;
        }
        mysqli_close($this->db->getDb());
        return false;
    }

    /**
     * Creates a new user and register
     * @param $username
     * @param $password
     * @param $email
     * @return bool
     */
    public function register($username, $password, $email)
    {

        $query = "insert into users (username, password, email, token, created_at, updated_at) values ('$username', '$password', '$email', null, NOW(), NOW())";
        $inserted = mysqli_query($this->db->getDb(), $query);
        mysqli_close($this->db->getDb());
        if ($inserted == 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Sign in the user
     * @param $username
     * @param $password
     * @return bool
     */
    public function signIn($username, $password)
    {


    
        $query = "select token from " . $this->db_table . " where username = '$username' AND password = '$password' AND token IS NOT NULL";
        $result = mysqli_query($this->db->getDb(), $query);
        if (mysqli_num_rows($result) > 0) {
            while ($row = $result->fetch_row()) {
                return $row[0];
            }
        }
        $query = null;
        $canUserLogin = $this->isLoginExist($username, $password);
        if ($canUserLogin) {
            $token = md5($username . $password . '-' . date('Y-m-d'));
            //echo $password; die;
            $query = "UPDATE " . $this->db_table . " SET token = '$token' WHERE username = '$username'";
            $updated = mysqli_query($this->db->getDb(), $query);
            if ($updated == 1) {
                mysqli_close($this->db->getDb());
                return $token;
            } else {
                mysqli_close($this->db->getDb());
                return null;
            }
        } else {
            mysqli_close($this->db->getDb());
            return null;
        }
    }

}