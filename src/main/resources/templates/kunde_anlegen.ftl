<#import "/spring.ftl" as spring/>
<#--<!DOCTYPE html>-->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Neuen Kunden anlegen</title>
    <style>
        <#include "mystyle.css">
    </style>
</head>
<body>
    <h1>Kunde hinzufuegen</h1>

    <#if errorMessage??>
        <div style="color: red; font-style: italic">
            ${errorMessage}
        </div>
    </#if>


<#--InputFelder für Values-->
<div class="new_customer_values">
    <fieldset>
    <form name="new_kunde" method="post" action="/hauptanzeige/kunde_anlegen">
<#--        Id: <input type="text" id="id" /><br>-->
        Vorname: <@spring.formInput "kundeForm.vorname" "" "text" /><br>
        Name: <@spring.formInput "kundeForm.name" "" "text"/><br>
        E-Mail: <@spring.formInput "kundeForm.email" "" "text"/><br>
        Stadt: <@spring.formInput "kundeForm.stadt" "" "text"/><br>
        <input type="submit" value="Erstellen" />
    </form>
    </fieldset>
    <br>
    <a href="/hauptanzeige">
        <button>Zurück</button>
    </a>
</div>
<br><br>

</body>
</html>