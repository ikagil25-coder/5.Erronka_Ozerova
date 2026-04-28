<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html lang="eu">
            <head>
                <title>ELIKAGAI DOHAINAK</title>
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        background-color: #f0f4f7;
                        margin: 0;
                        padding: 0;
                        color: #333;
                    }

                    .header-container {
                        background-color: white;
                        padding: 20px 0;
                        text-align: center;
                        border-bottom: 1px solid #ccc;
                    }

                    h1 {
                        font-size: 28px;
                        color: #333;
                        margin: 0;
                        text-transform: uppercase;
                        letter-spacing: 1px;
                    }

                    .main-content {
                        padding: 40px 10%;
                    }

                    h2 {
                        font-size: 24px;
                        margin-bottom: 20px;
                        font-weight: normal;
                    }

                    table {
                        width: 100%;
                        border-collapse: collapse;
                        background-color: white;
                        box-shadow: 0 2px 5px rgba(0,0,0,0.1);
                    }

                    th {
                        background-color: #c9d6df;
                        color: #333;
                        padding: 12px;
                        border: 1px solid #999;
                        font-size: 14px;
                    }

                    td {
                        padding: 10px;
                        border: 1px solid #ccc;
                        font-size: 14px;
                    }

                    tr:nth-child(even) {
                        background-color: #f9f9f9;
                    }
                </style>
            </head>
            <body>
                <div class="header-container">
                    <h1>ELIKAGAI DONAZIOAK</h1>
                </div>

                <div class="main-content">
                    <h2>Eguneko Donazioak</h2>
                    <table>
                        <thead>
                            <tr>
                                <th>&lt;Mota&gt;</th>
                                <th>&lt;Erreferentzia&gt;</th>
                                <th>&lt;Produktu Izena&gt;</th>
                                <th>&lt;Kopurua&gt;</th>
                                <th>&lt;Ekoizlea&gt;</th>
                                <th>&lt;Iraungitze Data&gt;</th>
                                <th>&lt;Hoztuta Mantendu&gt;</th>
                            </tr>
                        </thead>
                        <tbody>
                            <xsl:for-each select="donazioak/donazioa/elikagaiak/elikagaia">
                                <tr>
                                    <td><xsl:value-of select="@mota"/></td>
                                    <td><xsl:value-of select="erreferentzia"/></td>
                                    <td><xsl:value-of select="produktuaren_izena"/></td>
                                    <td><xsl:value-of select="kopurua"/></td>
                                    <td><xsl:value-of select="manufakturatzen_duen_enpresa"/></td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="iraungitze_data">
                                                <xsl:value-of select="iraungitze_data"/>
                                            </xsl:when>
                                            <xsl:otherwise>-</xsl:otherwise>
                                        </xsl:choose>
                                    </td>
                                    <td>
                                        <xsl:choose>
                                            <xsl:when test="hoztuta_mantendu">
                                                <xsl:value-of select="hoztuta_mantendu"/>
                                            </xsl:when>
                                            <xsl:otherwise>-</xsl:otherwise>
                                        </xsl:choose>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </tbody>
                    </table>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
