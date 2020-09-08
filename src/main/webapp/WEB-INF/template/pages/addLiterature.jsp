<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="row d-flex justify-content-center mt-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body pl-5 pr-5">
                <form method="post" action="/addLiterature"/>">
                    <input type="hidden" name="testId" value="${testId}">
                    <input type="hidden" name="questionId" value="${questionId}">
                    <div>
                        <label class="" for="description">Literature</label>
                        <input class="form-control" type="text" name="description" id="description">
                    </div>
                    <div>
                        <label class="" for="link">Link</label>
                        <input class="form-control" type="text" name="link" id="link">
                    </div>
                    <input class="btn btn-success" type="submit" value="Add">
                </form>
            </div>
        </div>
    </div>
</div>
