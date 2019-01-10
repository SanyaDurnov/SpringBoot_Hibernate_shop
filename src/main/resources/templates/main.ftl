<#import "parts/common.ftl" as c>
<@c.page>
<div>
    <form method="post" action="addProduct">
        <input type="text" name="productName" placeholder="Наименование">
        <input type = "number" name="productPrice", placeholder="Цена">
        <button type="submit">Добавить</button>
    </form>
</div>


<@c.loadButton "/loadAllProducts">

</@c.loadButton>
<div>
    <form method="post" action="/loadAllProducts">
        <button type="submit">Загрузить</button>
    </form>
</div>

<div>
<table border="1">
    <caption>Список доступных товаров</caption>
    <th>Id Товара</th>
    <th>Наименование</th>
    <th>Цена</th>
    {{#allProducts}}
            <tr>
                <td>{{id}}</td><td>{{productName}}</td><td>{{price}}</td>
            </tr>
    {{/allProducts}}
</table>

</div>
<p>---------------------------------------------------------------------------------------------------------------------</p>
<div>
    <form method="post" action="addOrder">
        <input type="text" name="orderName" placeholder="Номер Заказа">
        <input type = "number" name="quantity", placeholder="Количество">
        <input type = "text" name="productId", placeholder="Продукт">

        <button type="submit">Добавить</button>
    </form>
</div>

<div>
    <table border="1">
        <caption>Список заказов</caption>
        <th>Номер заказа</th>
        <th>Id товара</th>
        <th>Количество</th>
    <#list allOrders as orders>
        <tr>
            <td>${orders.orderName}</td>
            <td>${orders.product}</td>
            <td>${orders.quantity}</td>
        </tr>
    </#list>
    </table>
</div>
<div>
    <form method="post" action="/loadAllOrders">
        <button type="submit">Загрузить</button>
    </form>
</div>
<p>---------------------------------------------------------------------------------------------------------------------</p>
</body>
</html>
</@c.page>