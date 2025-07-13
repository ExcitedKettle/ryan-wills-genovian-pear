
## UserFlow:
(This is just an analysis of the overall set of requirements for fun)

1. The customer clicks on an advert stating that we can help to treat their condition.
   - A future requirement may need us to track source of traffic, perhaps perform AB testing - should not impact current decisions meaningfully.
2. They are then shown an informational landing page describing our service and then
   click "Start Consultation".
   - This page's content could be delivered via an api, but I think a headless CMS (eg. contentful) could be more suitable - both have pros and cons
3. They are asked a series of questions to collect personal and health information. This
   is our "Consultation". Upon completing the questions, the user is told whether there is
   any reason that we will likely not be able to provide them the medicine (e.g. if they
   have indicated that they have had an adverse reaction previously to the medicine).
   - `series of questions` - This again could come from a CMS however for I think this would be better served as an API
   - `collect personal and health information` - there may be merit in storing these 2 sets of indicia as separate backend calls. The personal information is probably going to be the same for all products, they may also get parsed quite differently
   - after storing a consultation request, traditionally you would return the UUID in the response and make that a cookie, however that may be unwise due to the sensitive nature of the data so maybe a login needs to be created quite early on for this product to remain secure.
4. The user enters their card details and signs up for a monthly subscription. Note at
   this point their card is not charged.
   - when does the user create an actual account? I guess at this point. In which case authorizing the consultation result may prove tricky.
   - Unsure how something like stripe feels about creating a future subscription without a date on it, you can easily create an invoice for the future and finalise it later or create a subscription to start on a certain date, but less sure out a future subscription without a known start date.
5. Later that day, a Genovian doctor reviews the data and chooses whether or not it is
   appropriate to prescribe the medication. All being well, the doctor creates the
   prescription.
   - consultation needs to be sent to a Dr/many Drs
   - Dr needs access to review the patient's data
   - Dr needs access to update the patient's consultation / Create a prescription 
   - Do we require any sort of push event?
6. Upon the prescription being created, the customer's card is charged and we dispatch
   the medicine.
   - This requirement slightly confuses me, is it a monthly subscription or a one off payment? If its a one off then we just need to finalise an invoice.


## notes:
 - Ideally the contents of the api package would be in a separate library, so they can be used by other applications.
 - I have written some tests to demonstrate how I would go about testing this, but have not spent the time fully implementing all tests
 - I have provided an api for looking up a consultation (though with very limited data presently) - notionally my thinking is that when a consultation is created a DR is async notified and will update the consultation appropriately.
 - I ran out of time to implement validation that all questions are answered but have commented in `ConsultationQuestionnaireStorageService` where I would do that validation (probably with a rules engine).

## Running the application
- Basic spring boot application, you should be able to right click `RyanWillsGenovianPearApplication` -> run, if there are issues you may need to do a maven clean install and make sure you are running java 24+
- I have attached a postman collection to the resources folder for your convenience, failing that curl requests are below with examples

### Get Questionnaire
curl --location 'localhost:8080/consultation/questionnaire?product=pear'

### Create Request
curl --location 'localhost:8080/consultation' \
--header 'Content-Type: application/json' \
--data '{
"questionnaireName":"pearQuestionnaire",
"answers": [
{
"answer": "Other",
"questionId": "bb3dc3f3-374e-4f7e-bdc3-f3374e3f7e84"
}
]
}'

### Lookup consultation
curl --location 'localhost:8080/consultation?id%20=bb3dc3f3-374e-4f7e-bdc3-f3374e3f7e84'