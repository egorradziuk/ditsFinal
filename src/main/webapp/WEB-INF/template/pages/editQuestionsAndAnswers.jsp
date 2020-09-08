<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="row d-flex justify-content-center mt-3">
    <div class="col-md-12">
        <div class="card">
            <div class="card-body pl-5 pt-5 pr-5">
                <form name="changeAnswer">
                    <p>
                        <select id="topics" name="topics" class="browser-default custom-select">
                            <c:forEach items="${topicList}" var="item">
                                <option value="" selected disabled hidden>Choose topic</option>
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </p>
                    <p>
                        <select id="tests" name="tests" class="browser-default custom-select">
                            <option value="" selected disabled hidden>Choose test</option>
                        </select>
                    </p>
                    <p>
                        <select id="questions" name="questions" class="browser-default custom-select">
                            <option value="" selected disabled hidden>Choose question</option>
                        </select>
                    </p>
                    <div id="answersTable">
                        <table id="tableAnswers" class="table table-hover table-sm">
                            <thead class="special-color-dark white-text">
                            <tr>
                                <th>Id</th>
                                <th>Description</th>
                                <th>Correct</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody></tbody>
                        </table>
                    </div>
                    <div id="editTestForm"></div>
                    <div id="addButtonForm"></div>
                    <div>
                        <a href="<c:url value="/"/>">Назад</a>
                    </div>

                </form>
            </div>
        </div>
    </div>
</div>
