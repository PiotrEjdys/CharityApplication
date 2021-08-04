<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="headerForm.jsp"/>
    <section class="form--steps">
      <div class="form--steps-instructions">
        <div class="form--steps-container">
          <h3>Ważne!</h3>
          <p data-step="1" class="active">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="2">
            Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
            wiedzieć komu najlepiej je przekazać.
          </p>
          <p data-step="3">
           Wybierz jedną, do
            której trafi Twoja przesyłka.
          </p>
          <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
      </div>

      <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>
        <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
        <form:form method="post" modelAttribute="donation" id="my_form">
          <!-- STEP 1: class .active is switching steps -->
          <div data-step="1" class="active">
            <h3>Zaznacz co chcesz oddać:</h3>
<%--            <c:forEach></c:forEach>--%>
<%--            <div class="form-group form-group--checkbox">--%>
<%--              <label>--%>
<%--              <span class="checkbox"></span>--%>
                <form:checkboxes   path="categories"
                                 items="${categories}" itemLabel="name" itemValue="id" id="category"/>
<%--                <span class="checkbox"></span>--%>
<%--                <span class="description"--%>
<%--                  >ubrania, które nadają się do ponownego użycia</span--%>
<%--                >--%>
<%--              </label>--%>
<%--            </div>--%>

<%--            <div class="form-group form-group--checkbox">--%>
<%--              <label>--%>
<%--                <input--%>
<%--                  type="checkbox"--%>
<%--                  name="categories"--%>
<%--                  value="clothes-useless"--%>
<%--                />--%>
<%--                <span class="checkbox"></span>--%>
<%--                <span class="description">ubrania, do wyrzucenia</span>--%>
<%--              </label>--%>
<%--            </div>--%>

<%--            <div class="form-group form-group--checkbox">--%>
<%--              <label>--%>
<%--                <input type="checkbox" name="categories" value="toys" />--%>
<%--                <span class="checkbox"></span>--%>
<%--                <span class="description">zabawki</span>--%>
<%--              </label>--%>
<%--            </div>--%>

<%--            <div class="form-group form-group--checkbox">--%>
<%--              <label>--%>
<%--                <input type="checkbox" name="categories" value="books" />--%>
<%--                <span class="checkbox"></span>--%>
<%--                <span class="description">książki</span>--%>
<%--              </label>--%>
<%--            </div>--%>

<%--            <div class="form-group form-group--checkbox">--%>
<%--              <label>--%>
<%--                <input type="checkbox" name="categories" value="other" />--%>
<%--                <span class="checkbox"></span>--%>
<%--                <span class="description">inne</span>--%>
<%--              </label>--%>
<%--            </div>--%>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn next-step">Dalej</button>
            </div>
          </div>

          <!-- STEP 2 -->
          <div data-step="2">
            <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>
            <div class="form-group form-group--inline">
              <label>
                Liczba 60l worków:
                <form:input path="quantity" id="quantity"/>
<%--                <input type="number" name="bags" step="1" min="1" />--%>
              </label>
            </div>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step">Dalej</button>
            </div>
          </div>



          <!-- STEP 4 -->
          <div data-step="3">
            <h3>Wybierz organizacje, której chcesz pomóc:</h3>

<%--            <div class="form-group form-group--checkbox">--%>
<%--              <label>--%>
<%--                <input type="radio" name="organization" value="old" />--%>
<%--                <span class="checkbox radio"></span>--%>
<%--                <span class="description">--%>
<%--                  <div class="title">Fundacja “Bez domu”</div>--%>
<%--                  <div class="subtitle">--%>
<%--                    Cel i misja: Pomoc dla osób nie posiadających miejsca--%>
<%--                    zamieszkania--%>
<%--                  </div>--%>
<%--                </span>--%>
<%--              </label>--%>
<%--            </div>--%>
            <form:radiobuttons path="institution" items="${institutions}" itemLabel="name" itemValue="id"/>

<%--            <div class="form-group form-group--checkbox">--%>
<%--              <label>--%>
<%--                <input type="radio" name="organization" value="old" />--%>
<%--                <span class="checkbox radio"></span>--%>
<%--                <span class="description">--%>
<%--                  <div class="title">Fundacja “Dla dzieci"</div>--%>
<%--                  <div class="subtitle">--%>
<%--                    Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji--%>
<%--                    życiowej.--%>
<%--                  </div>--%>
<%--                </span>--%>
<%--              </label>--%>
<%--            </div>--%>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step">Dalej</button>
            </div>
          </div>

          <!-- STEP 5 -->
          <div data-step="4">
            <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>



            <p>Kod pocztowy:<form:input path="zipCode" id="zipCode" /></p>
            <p>Ulica:<form:input path="street" id="street" /></p>
            <p>Miasto:<form:input path="city" id="city"/></p>
            <p>Uwagi dla kuriera<form:textarea path="pickUpComment" id="comment"/></p>
            <p>Data odbioru:<form:input type="date" path="pickUpDate" id="date"/></p>
            <p>Godzina odbioru:<form:input type="time" path="pickUpTime" id="time"/></p>




<%--            <div class="form-section form-section--columns">--%>
<%--              <div class="form-section--column">--%>
<%--                <h4>Adres odbioru</h4>--%>
<%--                <div class="form-group form-group--inline">--%>
<%--                  <label> Ulica <input type="text" name="address" /> </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--inline">--%>
<%--                  <label> Miasto <input type="text" name="city" /> </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--inline">--%>
<%--                  <label>--%>
<%--                    Kod pocztowy <input type="text" name="postcode" />--%>
<%--                  </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--inline">--%>
<%--                  <label>--%>
<%--                    Numer telefonu <input type="phone" name="phone" />--%>
<%--                  </label>--%>
<%--                </div>--%>
<%--              </div>--%>

<%--              <div class="form-section--column">--%>
<%--                <h4>Termin odbioru</h4>--%>
<%--                <div class="form-group form-group--inline">--%>
<%--                  <label> Data <input type="date" name="data" /> </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--inline">--%>
<%--                  <label> Godzina <input type="time" name="time" /> </label>--%>
<%--                </div>--%>

<%--                <div class="form-group form-group--inline">--%>
<%--                  <label>--%>
<%--                    Uwagi dla kuriera--%>
<%--                    <textarea name="more_info" rows="5"></textarea>--%>
<%--                  </label>--%>
<%--                </div>--%>
<%--              </div>--%>
<%--            </div>--%>
            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="button" class="btn next-step">Dalej</button>
            </div>
          </div>

          <!-- STEP 6 -->
          <div data-step="5">
            <h3>Podsumowanie Twojej darowizny</h3>
            <div class="summary">
              <div class="form-section">
                <h4>Oddajesz:</h4>
                <ul>
                  <li>
                    <span class="icon icon-bag"></span>
                    <span id="qt" class="summary--text"
                      > worki ubrań w dobrym stanie dla dzieci</span
                    >
                  </li>

                  <li>
                    <span class="icon icon-hand"></span>
                    <span id="inst" class="summary--text"
                      ></span
                    >
                  </li>
                </ul>
              </div>

              <div class="form-section form-section--columns">
                <div class="form-section--column">
                  <h4>Adres odbioru:</h4>
                  <ul>
                    <li id="st"></li>
                    <li id="ct"></li>
                    <li id="zip"></li>
                  </ul>
                </div>

                <div class="form-section--column">
                  <h4>Termin odbioru:</h4>
                  <ul>
                    <li id="dt"></li>
                    <li id="tm"></li>
                    <li id="cmt"></li>
                  </ul>
                </div>
              </div>
            </div>

            <div class="form-group form-group--buttons">
              <button type="button" class="btn prev-step">Wstecz</button>
              <button type="submit" class="btn">Potwierdzam</button>
            </div>
          </div>
        </form:form>
      </div>
    </section>
  <jsp:include page="footer.jsp"/>