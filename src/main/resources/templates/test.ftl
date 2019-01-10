<#import "parts/common.ftl" as c>
<#import "parts/tables.ftl" as t>

<@c.page>
    <h2>Add/Delete product</h2>
    <@c.addProductForm></@c.addProductForm>
    <@c.delProductById></@c.delProductById>
    <@c.loadButton "/main" "Load Products"></@c.loadButton>
    <@t.productTable></@t.productTable>
    <h2>Add order</h2>
    <@c.addOrderForm></@c.addOrderForm>
    <@t.orderTable></@t.orderTable>
    <@c.loadButton "/main" "Load Orders"></@c.loadButton>
</@c.page>