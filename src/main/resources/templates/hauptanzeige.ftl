<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Kundenverwaltungsmanagement</title>
    <style>
        <#include "mystyle.css">
    </style>
</head>
<body>
    <h1>Kundenverwaltungsmanagement</h1>

    <br><br>

<#--Tabelle:-->
<table class="kundentabelle">
    <tr>
        <th>Id</th>
        <th>Vorname</th>
        <th>Nachname</th>
        <th>E-Mail</th>
        <th>Stadt</th>
    </tr>
    <#list kunden as kunde>
        <tr>
            <td>${kunde.id}</td>
            <td>${kunde.vorname}</td>
            <td>${kunde.name}</td>
            <td>${kunde.email}</td>
            <td>
                <#if kunde.stadt?exists>
                ${kunde.stadt}
                </#if>
            </td>
        </tr>
    </#list>
</table>
<br><br>

    <div class="button_container">
        <a href="/hauptanzeige/kunde_anlegen">
            <button>Neuen Kunden anlegen</button>
        </a>
        <a href="/hauptanzeige/kunde_entfernen">
        <button>Kunde entfernen</button>
        </a>
    </div>

</body>
</html>