The Java code in the src folder is devided in three services:
· docProposalService
This service contains the DocumentProposalAgent and the two InterestProfiles DocumentProposalIP and ProtocolProposalIP. The task of the DocumentProposalAgent is to find documents or protocol depending on the incoming tokens, which then appear in the User Interface.
· saveProposalService
This service contains the SaveDocumentAgent and the SaveDocument Interst Profile.  The task of the SaveDocumentAgent has the task to save a new protocol after a video conference session.
· semanticService
This service contains the SemanticAgent and the SemanticChunk Interest Profile. The SemanticAgent has the task to find semantic information from the ontology for the incoming chunks.

The table below gives an overview over all agents with the according topics and events, depending if these are subscribed or published by another group. 
<table>
<tbody>
<tr>
<td><strong>Agents/InterestProfiles</strong></td>
<td><strong>Topic (subscribed)</strong></td>
<td><strong>Event (subscribed)</strong></td>
<td><strong>Events (published)</strong></td>
<td><strong>Topic (published)</strong></td>
</tr>
<tr>
<td>
<p>SemanticAgent/</p>
<p>SemanticAgentInterestProfile</p>
</td>
<td>ChunkGeneration</td>
<td>SentenceEvent</td>
<td>FeedbackEvent</td>
<td>SemanticChunk</td>
</tr>
<tr>
<td>
<p>DocProposalAgent/</p>
<p><strong>DocProposalInterestProfile</strong></p>
</td>
<td>DocRequest</td>
<td>DocRequestEvent</td>
<td>DocProposalEvent</td>
<td>DocProposal</td>
</tr>
<tr>
<td>
<p>DocProposalAgent/</p>
<p><strong>ProProposalInterestProfile</strong></p>
</td>
<td>DocRequest</td>
<td>DocRequestEvent</td>
<td>DocProposalEvent</td>
<td>DocProposal</td>
</tr>
<tr>
<td>
<p>SaveDocumentAgent/</p>
<p>SaveDocumentInterestProfile</p>
</td>
<td>Protocol</td>
<td>ProtocolEvent</td>
<td>-</td>
<td>-</td>
</tr>
</tbody>
</table>
<p>&nbsp;</p>
