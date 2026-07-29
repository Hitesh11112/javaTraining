<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Account Form Taken</h1>
	
	<form action="create" method="post">
                <div class="mb-3">
                    <label class="form-label">Account Number</label>
                    <input type="number" 
                           class="form-control"
                           name="accNo"
                           placeholder="Enter account number">
                </div>

                <div class="mb-3">
                    <label class="form-label">Account Holder Name</label>
                    <input type="text" 
                           class="form-control"
                           name="accHolderName"
                           placeholder="Enter holder name">
                </div>
                
                <div class="mb-3">
                    <label class="form-label">Bank Name</label>
                    <input type="text" 
                           class="form-control"
                           name="bankName"
                           placeholder="Enter bank name">
                </div>
                
                 <div class="mb-3">
                    <label class="form-label">Address</label>
                    <textarea class="form-control"
                              name="address"
                              rows="3"
                              placeholder="Enter address"></textarea>
                </div>
                
                
                <div class="mb-3">
                    <label class="form-label">Balance</label>
                    <input type="number" 
                           step="0.01"
                           class="form-control"
                           name="balance"
                           placeholder="Enter balance">
                </div>

                <button type="submit" class="btn btn-success">Save Account</button>
                <a href="/accounts" class="btn btn-secondary">Cancel</a>
            </form>
	
</body>
</html>