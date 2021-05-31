<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<script src="https://kit.fontawesome.com/8325699bff.js" crossorigin="anonymous"></script>
  <meta charset="UTF-8">
  <title>Dice Roller</title>
</head>
<body>
  <h1>Dice Roller</h1>
  <c:forEach items="${requestScope.batchRolls}" var="roll" varStatus="loop" >
    <h3>Roll #<c:out value="${loop.index + 1}" /></h3>
    <p>You rolled <c:out value="${roll.roll}." /></p>
    <p>
      <c:forEach items="${roll.diceDisplays}" var="diceDisplay" >
        <i class="fas fa-dice-<c:out value="${diceDisplay}"/>"></i>
      </c:forEach>
    </p>
    <c:if test="${roll.correct}">
      <p>You guessed <c:out value="${roll.guess}" />
      <p>
        <strong><c:out value="${roll.resultMessage}" /></strong>
      </p>
    </c:if>
    <c:if test="${!roll.correct && roll.guess != 0}">
      <p>You guessed <c:out value="${roll.guess}" />
    </c:if>
    <c:if test="${!roll.correct}">
      <p>
        <c:out value="${roll.resultMessage}" />
      </p>
    </c:if>
  </c:forEach>
</body>
</html>