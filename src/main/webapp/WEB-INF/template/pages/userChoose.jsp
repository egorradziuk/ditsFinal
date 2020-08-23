<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<form action="/goTest" >
    <select id="themes" name="themes" class="browser-default custom-select">
        <c:forEach items="${topics}" var="topic">
            <option value="" disabled selected hidden> Choose topic </option>
            <option>${topic.name}</option>
        </c:forEach>
    </select>
    <br>
    <select id="tests" name="testName" class="browser-default custom-select">
        <option value="" disabled selected hidden> Choose topic </option>
    </select>
    <br>
    <div class="text-center py-2 mt-3">
        <button class="btn btn-success" name="submit" type="submit"
                id="submit-button" disabled>take the
            test</button>
    </div>


    <div id="alertt" role="alert" aria-live="assertive" aria-atomic="true"
         class="toast" data-autohide="false">
        <div class="toast-header">
            <svg class=" rounded mr-2" width="20" height="20" xmlns="http://www.w3.org/2000/svg"
                 preserveAspectRatio="xMidYMid slice" focusable="false" role="img">
                <rect fill="#007aff" width="100%" height="100%" /></svg>
            <strong class="mr-auto">Attention!</strong>
            <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="toast-body">
            Selected test has no questions.
        </div>
    </div>
</form>


