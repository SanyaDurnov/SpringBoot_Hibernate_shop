<#macro productTable>
    <div>
        <table border="1">
            <caption>Product list</caption>
            <th>Product id</th>
            <th>Product name</th>
            <th>Price</th>
            <#list allProducts as product>
                <tr>
                    <td>${product.id}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                </tr>
            <#else >
                ${"There are no products"}
            </#list>
        </table>
    </div>
</#macro>
<#macro orderTable>
    <div>
        <table border="1">
            <caption>Order list</caption>
            <th>Order number</th>
            <th>Product Id</th>
            <th>Quantity</th>
            <#list allOrders as orders>
                <tr>
                    <td>${orders.orderName}</td>
                    <td>${orders.product}</td>
                    <td>${orders.quantity}</td>
                </tr>
            <#else >
                ${"There are no products"}
            </#list>
        </table>
    </div>
</#macro>