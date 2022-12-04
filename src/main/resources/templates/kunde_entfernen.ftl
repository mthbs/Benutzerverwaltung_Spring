<#import "/spring.ftl" as spring/>
<@spring.bind "options"/>
<#--<!DOCTYPE html>-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kunde entfernen</title>
    <style>
        <#include "mystyle.css">
    </style>
</head>
<body>
    <h1>Kunde entfernen</h1>

    <form method="POST" action="/hauptanzeige/kunde_entfernen">
<#--        <select required>-->
<#--            <#list categories! as category>-->
<#--                <option value=${category.id} >${category.name}</option>-->
<#--            </#list>-->
<#--        </select>-->
<#--        <@spring.formSingleSelect "deleteForm.column" "categories" ""/>-->
        <@spring.formSingleSelect "deleteForm.column", options, ""/>
        <@spring.formInput "deleteForm.value" "" "text"/>
        <input type="submit" value="Löschen"/>
    </form>
    <br>
    <a href="/hauptanzeige">
        <button>Zurück</button>
    </a>
</body>
</html>