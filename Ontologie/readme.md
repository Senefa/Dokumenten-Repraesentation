<h2 style="color: #5e9ca0;"><span style="color: #000000;"><strong>Ontologie</strong></span></h2>
<p>Ontologien, auch Wissensbasis genannt, spielen heutzutage eine zunehmend wichtige Rolle im Fortschritt des Semantic Webs, speziell in der Unterst&uuml;tzung der Informationsintegration. Die meisten Wissensbasen heutzutage decken spezifische Domainen ab, so auch die Ontologie zur Dokumentenrepr&auml;sentation.</p>
<p>Laut Thilo Koegst hat eine Ontologie Eigenschaften von Datenbanken, Softwarecode und Modellen. Denn zum einen kann eine Ontologie wie eine Datenbank genutz werden, da Abfragen ausgef&uuml;hrt werden k&ouml;nnen. Allerdings k&ouml;nnen mithilfe von Triples weit komplexere Aussagen beschrieben werden als in normalen Datenbanken.</p>
<p>Zum Anderen &auml;hnelt eine Ontologie einer Programmiersprache, da sie auch formal dargestellt werden kann und von maschinen lesbar ist. Allerdings, beschreiben Ontologien keine Prozeduren sondern nur deklarative Aussagen.</p>
<p>Als letztes werden Ontologien mit Modellen verglichen, und in der Tat handelt es sich bei Ontologien um formale, deklarative Modelle einer Dom&auml;ne und ebenalls die Entwicklung ist sehr &auml;hnlich. Allerdings ist es bei komplexen Ontologien, mit vielen Begriffen die graphische Darstellung schwierig und un&uuml;bersichtlich.</p>
<p>&nbsp;</p>
<h4>Aufbau der Ontologie</h4>
<p>Abbildung 1 zeigt die Klassenhierarchie der Ontologie, Abbildung 2 zeigt eine Liste der Beziehungen, die es zwischen den Klassen gibt. Abbildung 3 zeigt eine Liste der Attribute, die die Klassen beschreiben.</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<h4>Darstellung der Ontologie in einem Klassendiagramm</h4>
<p>Im Laufe des Projektes gab es einige Ans&auml;tze eine Ontologie zu Modellieren. Die finale Version ist als Klassendiagramm in dem im Order Abgelegten Bild zu sehen. Dabei sind die Klassen bis inklusive der zweiten Ebene, die Beziehungen in jeweils beide Richtungen und die jeweiligen Attribute abgebildet.&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;</p>
<h2 style="color: #2e6c80;">&nbsp;</h2>
<p>&nbsp;</p>
<p><strong>&nbsp;</strong></p>

<h2 style="color: #2e6c80;">&nbsp;</h2>
<h3 style="color: #2e6c80;"><span style="color: #000000;">Beispiels&auml;tze f&uuml;r die Live-Demo</span></h3>
<table>
<tbody>
<tr>
<td>
<p><strong>Beispiel Satz</strong></p>
</td>
<td>
<p><strong>Dokumente, die theoretisch angezeigt werden m&uuml;ssten</strong></p>
</td>
<td>
<p><strong>Auf der basis von folgenden chunks</strong></p>
</td>
</tr>
<tr>
<td><span style="font-weight: 400;">Let&rsquo;s talk about the costs of the IBM project</span></td>
<td><span style="font-weight: 400;">Costplan</span></td>
<td>
<p><span style="font-weight: 400;">project: ibm </span></p>
<p><span style="font-weight: 400;">keyword: costs</span></p>
<strong><br /></strong></td>
</tr>
<tr>
<td>
<p dir="ltr">How about the test of the Microsoft Project?</p>
</td>
<td>TestDoc</td>
<td>
<p dir="ltr">project:MicrosoftProject</p>
<p dir="ltr">keyword: test</p>
</td>
</tr>
<tr>
<td>
<p dir="ltr">What about the milestone in the telecom project?</p>
</td>
<td>&nbsp;MilestonePlan</td>
<td>&nbsp;
<p dir="ltr">project: telecom</p>
<p dir="ltr">keyword: milestone</p>
</td>
</tr>
<tr>
<td colspan="2"><strong>&nbsp;Additional Examples</strong>&nbsp;</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>
<p dir="ltr">Let&rsquo;s talk about the IBM project</p>
</td>
<td>PhasePlan, ProjectOrder, EnvironmentAnalysis</td>
<td>project: ibm</td>
</tr>
<tr>
<td>
<p dir="ltr">Let&rsquo;s talk about the costs&nbsp;</p>
<p dir="ltr">&nbsp;</p>
</td>
<td>CostPlan, CostStatement&nbsp;</td>
<td>keyword: costs&nbsp;</td>
</tr>
<tr>
<td>
<p dir="ltr">What milestone do we have next?</p>
<p dir="ltr">(speech macht nichts daraus)</p>
</td>
<td>MilestonPlan, ProjectPlan&nbsp;</td>
<td>keyword: milestone&nbsp;</td>
</tr>
<tr>
<td>
<p dir="ltr">Ok. Shall we look at the tasks leading to the milestone ahead?</p>
<p dir="ltr">&nbsp;</p>
</td>
<td>&nbsp;ToDoList, MilestonePlan, ProjectPlan</td>
<td>&nbsp;
<p dir="ltr">keyword: milestone</p>
<p dir="ltr">keyword: tasks</p>
</td>
</tr>
<tr>
<td>
<p dir="ltr">What about expenses?</p>
</td>
<td>CostPlan, CostStatement, Receipt&nbsp;</td>
<td>&nbsp;keyword: expenses</td>
</tr>
</tbody>
</table>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p><strong>&nbsp;</strong></p>
