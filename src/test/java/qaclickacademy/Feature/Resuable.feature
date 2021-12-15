Feature: TC2checkWordingInpage  

Scenario Outline: TC3_to_check_iframelink_navigateToNextPage
Given user open the url
Then clicks on frame link
Then click on iframeLink
Then navigate to nextPage
Then check "<word>" is present
Then Click on the text field and remove "<textToclear>" text
Then check the frame has parent menu
Then navigate to FrameId
Then close browser
Examples:
|word|textToclear|
|TinyMCE|Your content goes here.|

