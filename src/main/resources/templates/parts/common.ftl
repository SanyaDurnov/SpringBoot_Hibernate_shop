<#macro page>
    <!DOCTYPE HTML>
    <head>
        <title>Shop stock</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    <body>
    <h1>Shop Stock</h1>
    <#nested>
    </body>
</#macro>

<#macro addProductForm>
<div>
    <form method="post" action="addProduct">
        <input type="text" name="productName" placeholder="Product name">
        <input type = "number" name="productPrice", placeholder="Price">
        <button type="submit">Add</button>
    </form>
</div>
</#macro>

<#macro delProductById>
    <div>
        <form method="post" action="/delProductById">
            <input type="number" name="id" placeholder="Product id" required ="required"  >
            <button type="submit">Delete</button>
        </form>
    </div>
</#macro>

<#macro addOrderForm>
    <form method="post" action="addOrder">
        <input type="text" name="orderName" placeholder="Order number">
        <input type = "number" name="quantity", placeholder="Quantity">
        <input type = "text" name="productId", placeholder="Product id">
        <button type="submit">Add</button>
    </form>
</div>
</#macro>

<#macro loadButton request buttonText>
    <div>
        <form method="get" action="${request}">
            <input type="text" name="orderName">
            <button type="submit">${buttonText}</button>
        </form>
    </div>
</#macro>

<#macro textAdd text>
    <div>
        ${text}
    </div>
</#macro>

