<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accounts List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
      rel="stylesheet">

<style>
body{
    background-color:#f5f5f5;
}

.container{
    margin-top:40px;
}

h1{
    color:#0d6efd;
    margin-bottom:20px;
}

.table{
    background:white;
}

.btn{
    margin-right:5px;
}
</style>

</head>

<body>

<div class="container">

    <div class="d-flex justify-content-between align-items-center mb-3">
        <h1>Accounts List</h1>
        
        <div>
            <!-- Fixed Home Link: Points dynamically to your application root context -->
            <a href="${pageContext.request.contextPath}" class="btn btn-outline-secondary">Home</a>
            
            <a href="accounts/add" class="btn btn-primary">
                Add Account
            </a>
        </div>
    </div>

    <table class="table table-bordered table-hover table-striped align-middle">

        <thead class="table-dark">
            <tr>
                <th>Account ID</th>
                <th>Holder Name</th>
                <th>Balance</th>
                <th>Address</th>
                <th>Actions</th>
            </tr>
        </thead>

        <tbody>

        <c:forEach items="${accountList}" var="acc">

            <tr>
                <td>${acc.accNo}</td>
                <td>${acc.accHolderName}</td>
                <td>₹${acc.balance}</td>
                <td>${acc.address}</td>

                <td>
                    <a href="accounts/update/${acc.accNo}" class="btn btn-success btn-sm">Update</a>

                    <a href="accounts/delete/${acc.accNo}" class="btn btn-danger btn-sm">Delete</a>

                    <a href="accounts/info/${acc.accNo}" class="btn btn-info btn-sm text-white">Info</a>
                </td>
            </tr>

        </c:forEach>

        </tbody>

    </table>

</div>

</body>
</html>