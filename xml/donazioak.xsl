<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" indent="yes"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Donazioak</title>
            </head>
            <body>
                <h1>Donazioen Zerrenda</h1>
                <xsl:for-each select="donazioak/donazioa">
                    <div style="border: 1px solid black; margin: 10px; padding: 10px;">
                        <h2>Enpresa: <xsl:value-of select="enpresa_emailea/enpresaren_izena"/> (<xsl:value-of select="enpresa_emailea/ifk"/>)</h2>
                        <p>Data: <xsl:value-of select="data"/></p>
                        
                        <table border="1">
                            <tr>
                                <th>Produktua</th>
                                <th>Erreferentzia</th>
                                <th>Mota</th>
                                <th>Kopurua</th>
                                <th>Ekoizlea</th>
                                <th>Xehetasunak</th>
                            </tr>
                            <xsl:for-each select="elikagaiak/elikagaia">
                                <tr>
                                    <td><xsl:value-of select="produktuaren_izena"/></td>
                                    <td><xsl:value-of select="erreferentzia"/></td>
                                    <td><xsl:value-of select="@mota"/></td>
                                    <td><xsl:value-of select="kopurua"/></td>
                                    <td><xsl:value-of select="manufakturatzen_duen_enpresa"/></td>
                                    <td>
                                        <xsl:if test="@mota='iragankorra'">
                                            Iraungitzea: <xsl:value-of select="iraungitze_data"/> / 
                                            Hoztea: <xsl:value-of select="hoztuta_mantendu"/>
                                        </xsl:if>
                                        <xsl:if test="@mota='ez iragankorra'">
                                            Kontserba: <xsl:value-of select="kontserba"/>
                                        </xsl:if>
                                    </td>
                                </tr>
                            </xsl:for-each>
                        </table>
                    </div>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
