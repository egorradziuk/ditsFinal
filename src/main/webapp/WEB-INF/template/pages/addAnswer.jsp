
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row d-flex justify-content-center mt-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body pl-5 pr-5">
                <form method="post" action="/addAnswer"/>">
                    <div class="">
                        <input type="hidden" name="questionId" value="${questionId}" id="questionId">
                    </div>
                    <div class="">
                        <label for="description" class="font-weight-light">Description</label>
                        <input id="description" name="description" class="form-control" autocomplete="off"/>
                    </div>
                    <div class="">
                        <label for="correct" class="font-weight-light">Correct</label>
                        <select id="correct" name="correct" class="browser-default custom-select">
                            <option value="true">True</option>
                            <option selected value="false">False</option>
                        </select>
                    </div>
                    <div class="text-center py-2 mt-3">
                        <input class="btn btn-success" type="submit" value="Create">
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
