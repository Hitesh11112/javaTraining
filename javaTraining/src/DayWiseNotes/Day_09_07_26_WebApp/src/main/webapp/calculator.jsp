<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Simple Calculator</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow">
                <div class="card-header bg-primary text-white text-center">
                    <h3>Simple Calculator</h3>
                </div>
                <div class="card-body">
                    <form action="result.jsp">
                        <div class="mb-3">
                            <label class="form-label">First Number</label>
                            <input type="number" class="form-control" name="firstnum" required>
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Second Number</label>
                            <input type="number" class="form-control" name="secondnum" required>
                        </div>
                        <div class="d-flex justify-content-between">
                            <button type="submit" class="btn btn-success" name="op" value="+">+</button>
                            <button type="submit" class="btn btn-danger" name="op" value="-">-</button>
                            <button type="submit" class="btn btn-warning" name="op" value="*">*</button>
                            <button type="submit" class="btn btn-info text-white" name="op" value="/">/</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>