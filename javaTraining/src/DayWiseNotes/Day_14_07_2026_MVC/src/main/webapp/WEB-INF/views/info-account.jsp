<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Account Info</title>
</head>
<body>

<div action="../../accounts/modify" class="container mt-4">
    <h1>Account Details</h1>
    <table class="table table-bordered w-50">
        <tr>
            <th>Account Number</th>
            <td>${account.accNo}</td>
        </tr>
        <tr>
            <th>Account Holder Name</th>
            <td>${account.accHolderName}</td>
        </tr>
        <tr>
            <th>Bank Name</th>
            <td>${account.bankName}</td>
        </tr>
        <tr>
            <th>Address</th>
            <td>${account.address}</td>
        </tr>
        <tr>
            <th>Balance</th>
            <td>${account.balance}</td>
        </tr>
    </table>
	<a href="${pageContext.request.contextPath}/accounts" class="btn btn-primary">Back</a>
</div>

</body>
</html>