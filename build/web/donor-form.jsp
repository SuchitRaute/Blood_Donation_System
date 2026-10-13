<!DOCTYPE html>
<html>

<head>

    <title>Blood Donation Registration</title>

    <style>

        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 30px;
        }

        .container {
            width: 600px;
            margin: auto;
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px #cccccc;
        }

        h1 {
            text-align: center;
        }

        h2 {
            margin-top: 25px;
        }

        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
        }

        input, select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            padding: 12px;
            margin-top: 25px;
            background-color: #333333;
            color: white;
            border: none;
            font-size: 16px;
            cursor: pointer;
        }

    </style>

</head>

<body>

<div class="container">

    <h1>Blood Donation Management System</h1>

    <form action="DonorServlet" method="post">

        <h2>Donor Details</h2>

        <label>Full Name</label>

        <input type="text"
               name="name"
               minlength="2"
               maxlength="100"
               required>


        <label>Email</label>

        <input type="email"
               name="email"
               required>


        <label>Phone Number</label>

        <input type="text"
               name="phone"
               pattern="[0-9]{10}"
               maxlength="10"
               required>


        <label>Blood Group</label>

        <select name="bloodGroup" required>

            <option value="">Select Blood Group</option>

            <option value="A+">A+</option>
            <option value="A-">A-</option>
            <option value="B+">B+</option>
            <option value="B-">B-</option>
            <option value="AB+">AB+</option>
            <option value="AB-">AB-</option>
            <option value="O+">O+</option>
            <option value="O-">O-</option>

        </select>


        <label>Age</label>

        <input type="number"
               name="age"
               min="18"
               max="65"
               required>


        <h2>Blood Donation Details</h2>


        <label>Donation Date</label>

        <input type="date"
               name="donationDate"
               required>


        <label>Blood Units</label>

        <input type="number"
               name="bloodUnits"
               min="0.1"
               step="0.1"
               required>


        <label>Donation Type</label>

        <select name="donationType" required>

            <option value="">
                Select Donation Type
            </option>

            <option value="Voluntary">
                Voluntary
            </option>

            <option value="Replacement">
                Replacement
            </option>

            <option value="Camp">
                Blood Donation Camp
            </option>

        </select>


        <button type="submit">
            Register Donor
        </button>

    </form>

</div>

</body>

</html>