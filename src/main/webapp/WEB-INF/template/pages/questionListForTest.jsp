<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div>
    <label>Test id:${test.id}</label>
</div>
<div>
    <label>Name:${test.name}</label>
</div>
<div class="row">
    <div class="col">
        <c:if test="${!empty test.questions}">
            <table class="table table-hover table-sm">
                <thead class="special-color-dark white-text">
                <tr>
                    <th>Id</th>
                    <th>Description</th>
                    <th></th>
                    <th></th>
                    <th>Literature</th>
                </tr>
                </thead>
                <c:forEach items="${test.questions}" var="item">
                    <tr>
                        <th>${item.id}</th>
                        <th>${item.description}</th>
                        <th><a href="<c:url value="/editQuestion/${item.id}"/>"><i
                                class="fas fa-edit"></i></a></th>
                        <th><a href="<c:url value="/deleteQuestion/${item.id}/${test.id}"/>"><i
                                class="fas fa-trash-alt"></i></a></th>
                        <th>
                            <table class="table table-hover table-sm">
                                <thead class="special-color-dark white-text">
                                <tr>
                                    <th>Id</th>
                                    <th>Literature</th>
                                    <th></th>
                                    <th></th>
                                    <th>Count Link</th>
                                    <th>Links</th>
                                </tr>
                                </thead>
                                <c:forEach items="${item.literature}" var="literature">
                                    <tr>
                                        <th>${literature.id}</th>
                                        <th>${literature.description}</th>
                                        <th><a href="<c:url value="/editLiterature/${literature.id}/${test.id}"/>"><i
                                                class="fas fa-edit"></i></a></th>
                                        <th><a href="<c:url value="/deleteLiterature/${literature.id}/${test.id}"/>"><i
                                                class="fas fa-trash-alt"></i></a></th>
                                        <th>${literature.links.size()}</th>
                                        <th>
                                            <table class="table table-hover table-sm">
                                                <thead class="special-color-dark white-text">
                                                <tr>
                                                    <th>Link</th>
                                                    <th></th>
                                                </tr>
                                                </thead>
                                                <c:forEach items="${literature.links}" var="link">
                                                    <tr>
                                                        <th>${link.link}</th>
                                                        <th><a href="<c:url value="/deleteLink/${link.id}/${test.id}"/>"><i
                                                                class="fas fa-trash-alt"></i></a></th>
                                                    </tr>
                                                </c:forEach>
                                            </table>
                                            <%--<a href="<c:url value="/addLink/${literature.id}/${test.id}"/>">Add Link</a>--%>
                                        </th>
                                    </tr>
                                </c:forEach>
                                <a href="<c:url value="/addLiterature/${item.id}/${test.id}"/>">Add Literature</a>
                            </table>
                        </th>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>
<a href="<c:url value="/addQuestion/${test.id}"/>">Add question</a>
