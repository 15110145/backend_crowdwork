**Show User**
----
  Returns json data about a single user.

* **URL**

  /finduser/id

* **Method:**

  `GET`
  
*  **URL Params**

   **Required:**
 
   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    ```json
    "id": 1,
    "name": "Đức Quang",
    "date_of_birth": "1997-03-06T17:00:00.000+0000",
    "email": "ducquang.citynow",
    "password": "123",
    "address": "QN",
    "cmnd": "123456789",
    "avatar": "host",
    "role": "ADMIN",
    "delFlag": false,
    "createUser": 1,
    "updateUser": null,
    "createTime": "2018-07-29T04:13:37.000+0000",
    "updateTime": "2018-07-29T17:00:00.000+0000",
    "comments": [],
    "verifyEmail": true
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```url
    /finduser/1
  ```

**Show All User**
----
  Returns json data about all user.

* **URL**

  /findalluser

* **Method:**

  `GET`
  

* **Data Params**

  None

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    ```json
    "id": 1,
    "name": "Đức Quang",
    "date_of_birth": "1997-03-06T17:00:00.000+0000",
    "email": "ducquang.citynow",
    "password": "123",
    "address": "QN",
    "cmnd": "123456789",
    "avatar": "host",
    "role": "ADMIN",
    "delFlag": false,
    "createUser": 1,
    "updateUser": null,
    "createTime": "2018-07-29T04:13:37.000+0000",
    "updateTime": "2018-07-29T17:00:00.000+0000",
    "comments": [],
    "verifyEmail": true
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```url
    /findalluser
  ```

**Save User**
----
  Returns String "User saved !"

* **URL**

  /saveuser

* **Method:**

  `POST`
  
*  **URL Params**

    None

* **Data Params** 

    ```json
    "name": "Đức Quang",
    "date_of_birth": "1997-03-06T17:00:00.000+0000",
    "email": "ducquang.citynow",
    "password": "123",
    "address": "QN",
    "cmnd": "123456789",
    "avatar": "host",
    "role": "ADMIN",
    "createUser": 1,
    ```

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    ```
    User saved !
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```url
    /saveuser
  ```

**Update User**
----
  Returns String "User updated !"

* **URL**

  /updateuser

* **Method:**

  `PUT`
  
*  **URL Params**

    None

* **Data Params** 

    ```json
    "id": 1,
    "name": "Đức Quang",
    "date_of_birth": "1997-03-06T17:00:00.000+0000",
    "email": "ducquang.citynow",
    "password": "123",
    "address": "QN",
    "cmnd": "123456789",
    "avatar": "host",
    "role": "ADMIN",
    "delFlag": false,
    "updateUser": 2,
    "verifyEmail": true
    ```

* **Success Response:**

  * **Code:** 200 <br />
    **Content:** 
    ```
    User updated !
    ```
 
* **Error Response:**

  * **Code:** 404 NOT FOUND <br />
    **Content:** `{ error : "User doesn't exist" }`

  OR

  * **Code:** 401 UNAUTHORIZED <br />
    **Content:** `{ error : "You are unauthorized to make this request." }`

* **Sample Call:**

  ```url
    /updateuser
  ```