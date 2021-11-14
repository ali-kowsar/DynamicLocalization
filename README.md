# DynamicLocalization
# The application download localization file from Google drive. 
The File contain localize data in JSON format.

# Features
* Support **java** projects.
* Application uses **MVVM** pattern to prevent interuption during network call due to orienatation change.
* Display "Hello World" text in localize format with respect to user action.
* •	This localization file hosted externally (here Google Drive) and not inside the APK itself.
* The URL for the localization File : https://drive.google.com/file/d/1W34z4OFjtzvJLwEPA4mTNhuRCOxovZkc/view?usp=drivesdk
* Data format for the Localization file is JSON
* {
  "locale": [
    {
      "country_code":"en",
      "res_ids":
      {
      "hello_world": "Hello World",
      "button_hindi": "Hindi",
      "button_chinese": "Chinese",
      "button_eng": "English",
      "button_text_arabic": "Arabic",
      "localize_text": "Hello World"
    }},
    {
      "country_code":"hi",
      "res_ids":{
      "hello_world": "Hello World",
      "button_hindi": "Hindi",
      "button_chinese": "Chinese",
      "button_eng": "English",
      "button_text_arabic": "Arabic",
      "localize_text": "नमस्ते दुनिया"
    }},
    ...
    ...
    ]
    }
* In this application I am using JSON data format to manage data key/value pair. So it will fetch faster in constant time .
* When app start, we request network call for localization file from Google Drive (URL mentioned above).
* Response data store in app using optimised data structure to make faster retrieve.
* In this app, I given 4 button (Enlish,Hindi,Arabic and Chinese). When user press any button, app search corresponding localixed string to the  file.
* If corresponding data found, then set localised string ("Hello World") to the text view.
* If localize text not found in db, then retrieve data from android native string resources localization and set to the text view.
 # Extend the app
 * No need to change any logice for getting localize test from localization file.
 * Just update the server localization file after added new res id
 * To get any translated string corresponding locale, just called a LocaleViewModel's method **getLocaleString(locale,"localize_text")**  with locale ('en'/'hi'/'zh'/...) and string res id(mentioned in localization file) 2 pamameters.
 * If file already exist, then it return localize string.
 * Just use return localize string and set to the new added text view. 


