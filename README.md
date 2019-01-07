# Call-Service

Steps:
1. Install the following app-debug.apk file in your phone.
2. Give the notifcation access permission for the app to run.

Implementation:

Since it is not possible to get call status of outgoing call using Telephony manager. I have implemented Notification listener which will grab the change in notification when the call is picked up. I have searched for many methods but this was the only method which I found working in some cases.
