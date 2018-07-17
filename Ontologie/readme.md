<h2>Ontology</h2>
<p>Ontologies, also known as the knowledge base, are playing an increasingly important role in the progress of the Semantic Web, especially in supporting information integration. Most knowledge bases today cover specific domains, including ontology for document representation.</p>
<p>According to Thilo Koegst, an ontology has properties of databases, software code and models. On the one hand, an ontology can be used like a database, since queries can be executed. However, triples can be used to describe much more complex statements than in normal databases.</p>
<p>On the other hand, an ontology resembles a programming language, since it can also be displayed formally and is readable by machines. However, ontologies do not describe procedures but only declarative statements.</p>
<p>Finally, ontologies are compared with models, and indeed ontologies are formal, declarative models of a domain and the development is very similar. However, with complex ontologies, with many terms the graphical representation is difficult and confusing.</p>
<p>&nbsp;</p>
<h4>Structure of ontology</h4>
<p>Picture 1 shows the class hierarchy of the ontology, Picture 2 shows a list of the relationships that exist between the classes. Picture 3 shows a list of attributes describing the classes.</p>
<p>&nbsp;</p>
<h4>Representation of ontology in a class diagram</h4>
<p>In the course of the project there were some approaches to modeling an ontology. The final version is shown as a class diagram in the image placed in the order. The classes up to and including the second level, the relationships in both directions and the respective attributes are mapped.</p>

<h2 style="color: #2e6c80;">&nbsp;</h2>
<h3 style="color: #2e6c80;"><span style="color: #000000;">Sample sentences for the live demo </span></h3>
<table>
<tbody>
<tr>
<td>
<p><strong>Sentence Example</strong></p>
</td>
<td>
<p><strong>Documents that should theoretically be displayed </strong></p>
</td>
<td>
<p><strong>Based on the following chunks</strong></p>
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
