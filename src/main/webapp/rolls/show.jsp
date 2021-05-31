<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="diceRoll" value="${requestScope.diceRoll}" />

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <script src="https://kit.fontawesome.com/8325699bff.js" crossorigin="anonymous"></script>
  <title>Dice Roller</title>
</head>
<body>
  <h1>Dice Roller</h1>
  <p>You rolled <c:out value="${diceRoll.roll}." /></p>
  <p>
    <c:forEach items="${diceRoll.diceDisplays}" var="diceDisplay" >
      <i class="fas fa-dice-<c:out value="${diceDisplay}"/>"></i>
    </c:forEach>
  </p>

  <c:if test="${diceRoll.guess != null && diceRoll.guess != 0 && diceRoll.correct}">
    <p>You guessed <c:out value="${diceRoll.guess}" />
    <p>
      <strong><c:out value="${diceRoll.resultMessage}" /></strong>
    </p>
  </c:if>
  <c:if test="${diceRoll.guess != null && diceRoll.guess != 0 && !diceRoll.correct}">
    <p>You guessed <c:out value="${diceRoll.guess}" />
    <p>
      <c:out value="${diceRoll.resultMessage}" />
    </p>
  </c:if>
</body>
</html>


