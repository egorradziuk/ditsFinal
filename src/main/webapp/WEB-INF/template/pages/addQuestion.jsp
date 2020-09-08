<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="row d-flex justify-content-center mt-3">
    <div class="col-md-6">
        <div class="card">
            <div class="card-body pl-5 pr-5">
                <form method="post" action="/addQuestion"/>">
                    <div class="">
                        <input type="hidden" value="${test.id}" name="testId" id="testId"/>
                    </div>
                    <div class="">
                        <label class="" for="description">Description</label>
                        <input class="form-control" type="text" name="description" id="description">
                    </div>
                    <div>
                        <label class="" for="literature">Literature</label>
                        <input class="form-control" type="text" name="literature" id="literature">
                    </div>
                    <div>
                        <label class="" for="link">Link</label>
                        <input class="form-control" type="text" name="link" id="link">
                    </div>

                    <div>
                        <label for="answers">Choose count answers</label>
                        <select id="answers" name="answers" class="select-dropdown form-control">
                            <option value="" selected disabled hidden>Choose count answer</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                        </select>
                    </div>
                    <div>
                        <label class="" for="answerList">Answers</label>
                        <table id="answerList" class="table table-hover table-sm">
                            <thead class="special-color-dark white-text">
                            <tr>
                                <th>№</th>
                                <th>Answer</th>
                                <th>Correct</th>
                            </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <input class="btn btn-success" type="submit" value="Add">
                </form>
            </div>
        </div>
    </div>
</div>