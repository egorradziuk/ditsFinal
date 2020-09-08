<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row d-flex justify-content-center mt-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body pl-5 pr-5">
                <form method="post" action="/editAnswer"/>">
                    <div class="">
                        <input type="hidden" name="questionId" value="${answer.question.id}" id="questionId">
                        <input type="hidden" name="id" readonly value="${answer.id}" id="id">
                    </div>
                    <div class="">
                        <label for="description" class="font-weight-light">Description</label>
                        <input name="description" id="description" class="form-control mb-4"
                               value="${answer.description}">
                    </div>
                    <div class="">
                        <label for="correct" class="">Correct</label>
                        <select id="correct" name="correct" class="select-dropdown form-control mb-4">
                            <option value="true">True</option>
                            <option selected value="false">False</option>
                        </select>
                    </div>
                    <div class="text-center py-2 mt-3">
                        <input class="btn btn-success" name="submit" type="submit" value="Edit">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

