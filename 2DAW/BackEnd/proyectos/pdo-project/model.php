<?php

/**
*
*/
class ShopModel
{
    private $pdo;

    function __construct()
    {
        //DATABASE info. Edit this for your local configuration.
        $host = 'localhost';
        $dbname = 'tiendas_gandia';
        $username = 'root';
        $password = '';

        //Create the PDO object
        try {
            $dsn = 'mysql:host='.$host.';dbname='.$dbname.';charset=utf8';
            $this->pdo = new PDO($dsn, $username, $password);
        } catch (Exception $e){
            echo "Unable to conect";
        }
    }

    /**
     * This function returns all the ocurrences on cg_store as an associative
     * array
     **/
    public function retrieveAll()
    {
        $sql = "SELECT store_name, store_address, store_city, store_phone,
        area_store_name as area, store_email, store_id
        FROM cg_store, cg_area_store
        WHERE cg_store.store_area_id = cg_area_store.area_store_id";
        try {
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute();
            return $stmt->fetchAll();

        } catch (Exception $e) {
            echo "Something failed!";
        }
    }

    public function register(){
        $data = array(
            $_POST['store_name'],
            $_POST['store_area_id'],
            $_POST['store_address'],
            $_POST['store_city'],
            $_POST['store_phone'],
            $_POST['store_email']
            );


        try {
            $sql = "INSERT INTO cg_store(store_name, store_area_id,
                store_address, store_city, store_phone, store_email)
                VALUES(?,?,?,?,?,?)";
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute($data);

        } catch (Exception $e) {
            echo "Something failed!";
        }
        header("location: index.php");
    }

    public function delete($id)
    {

        try {
            $sql = "DELETE FROM cg_store WHERE store_id = ?";
            $stmt = $this->pdo->prepare($sql);
            $stmt->execute(array($id));

        } catch (Exception $e) {
            echo "Something failed!";
        }

        header("location: index.php");
    }

    public function getStoreById($id)
    {
        try {
            $sql = "SELECT * FROM cg_store WHERE store_id = ?";

            $stmt = $this->pdo->prepare($sql);
            $stmt->execute(array($id));
            return $stmt->fetch();
        } catch (Exception $e) {
            echo "Something failed!";
        }
    }

    public function updateShop($shopData)
    {
        try {
            $sql = "UPDATE cg_store
                        set store_name = ?,
                            store_area_id = ?,
                            store_address = ?,
                            store_city = ?,
                            store_phone = ?,
                            store_email = ?
                        where store_id = ?";

            $stmt = $this->pdo->prepare($sql);
            $stmt->execute($shopData);
        } catch (Exception $e) {
            echo "Something failed!";
        }
        header("location: index.php");
    }
}

?>