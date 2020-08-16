<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<div class="row mt-3">
    <div class="col">
        <h2 class="title h2 text-center">List of Tests</h2>
    </div>
</div>

<%--<ul class="list-group">--%>
<%--    <li class="list-group-item d-flex justify-content-between align-items-center">--%>
<%--        Cras justo odio--%>
<%--        <span class="badge badge-primary badge-pill">14</span>--%>
<%--    </li>--%>
<%--    <li class="list-group-item d-flex justify-content-between align-items-center">--%>
<%--        Dapibus ac facilisis in--%>
<%--        <span class="badge badge-primary badge-pill">2</span>--%>
<%--    </li>--%>
<%--    <li class="list-group-item d-flex justify-content-between align-items-center">--%>
<%--        Morbi leo risus--%>
<%--        <span class="badge badge-primary badge-pill">1</span>--%>
<%--    </li>--%>
<%--</ul>--%>


<c:if test="${!empty listTopicsWithTests}">
<div class="accordion" id="accordion01">

    <c:forEach items="${listTopicsWithTests}" var="topicWithTests">
        <div class="card z-depth-0 bordered">
            <div class="card-header" id="headingTwo">
                <h5 class="mb-0">
                    <button class="btn btn-link collapsed" type="button" data-toggle="collapse"
                            data-target="#collapse${topicWithTests.id}" aria-expanded="false" aria-controls="collapse${topicWithTests.id}">
                            ${topicWithTests.name}
                    </button>
                </h5>
            </div>
            <div id="collapse${topicWithTests.id}" class="collapse" aria-labelledby="heading${topicWithTests.id}" data-parent="#accordion01">
                <div class="card-body">
    <%--START!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!--%>
                    <div class="row">
                        <div class="col">
                            <table class="table table-hover table-sm">
                                <thead class="special-color-dark white-text">
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${topicWithTests.tests}" var="test">
                                    <tr>
                                        <td><h5 class="text-black-50"><strong>${fn:toUpperCase(test.name)} (${test.description})</strong></h5>
                                            <ol>
                                                <c:forEach items="${test.questions}" var="question">
                                                    <li><h5>${question.description}</h5></li>
                                                    <ul>
                                                        <c:forEach items="${question.answers}" var="answer">
                                                            <li class="list-unstyled">
                                                                <c:if test="${answer.correct}">
                                                                    <i class="far fa-check-circle"></i>
                                                                </c:if>
                                                                <c:if test="${!answer.correct}">
                                                                    <i class="far fa-circle"></i>
                                                                </c:if>
                                                                    ${answer.description}
                                                            </li>
                                                        </c:forEach>
                                                    </ul>
                                                    <h5>Literature:</h5>
                                                    <c:if test="${empty question.literature}">
                                                        none
                                                    </c:if>
                                                    <c:if test="${!empty question.literature}">
                                                        <ul>
                                                            <c:forEach items="${question.literature}" var="literature">
                                                                <c:forEach items="${literature.links}" var="link">
                                                                    <li class="list-unstyled"><a class="text-success" href="${link.link}">${literature.description}</a></li>
                                                                </c:forEach>
                                                            </c:forEach>
                                                        </ul>
                                                    </c:if>
                                                    <hr>
                                                </c:forEach>
                                            </ol>
                                        </td>
                                        <td><a href="<%=application.getContextPath()%>/tests/edit/${test.id}"><i class="fas fa-edit"></i></a></td>
                                        <td><a href="<%=application.getContextPath()%>/tests/delete/${test.id}"><i class="fas fa-trash-alt"></i></a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
    <%--FINISH!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!--%>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
</c:if>
<c:if test="${empty listTopicsWithTests}">
    <div class="row mt-3">
        <div class="col">
            <h4 class="title h4-responsive text-center text-success">Sorry! test list is empty</h4>
        </div>
    </div>
</c:if>
<div class="mt-3 text-right">
    <a href="<%=application.getContextPath()%>/tests/create" class="btn btn-success">Create test</a>
</div>
<div class="mt-3 text-right pr-2">
    <a href="<%=application.getContextPath()%>/" class="text-success">Back to main page</a>
</div>
