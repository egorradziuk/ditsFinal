<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="row d-flex justify-content-center mt-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body pl-5 pr-5">
                <form method="post" action="/editLiterature"/>">
                    <input type="hidden" name="testId" value="${testId}">
                    <input type="hidden" name="id" value="${literature.id}">
                    <input type="hidden" name="questionId" value="${literature.question.id}">
                    <input type="hidden" name="size" value="${literature.links.size()}">
                    <div>
                        <label for="description">Literature</label>
                        <input type="text" class="form-control" name="description" id="description"
                               value="${literature.description}">
                    </div>
                    <div>
                        <table class="table table-hover table-sm">
                            <thead class="special-color-dark white-text">
                            <tr>
                                <th>Id</th>
                                <th>Link</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${literature.links}" var="item">
                                <tr>
                                    <th><input type="number" class="form-control" name="linkId[]" value="${item.id}" readonly> </th>
                                    <th><input type="text" class="form-control" name="link[]" value="${item.link}"></th>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <input type="submit" value="Edit" class="btn btn-success">
                </form>
            </div>
        </div>
    </div>
</div>
