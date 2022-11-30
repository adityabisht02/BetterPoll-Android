# BetterPoll-Android
This is an android application which can be setup and used as a complete campus platform. A campus (eg.- a college campus) provides
many facilities such as a mess, shuttle services. BetterPoll is an attempt to create a completely open source campus management system.
This repository contains the frontend ( an android application) of the application. <br>

For the backend repo you can check out : https://github.com/adityabisht02/BetterPoll-Backend <br>

This project will have an admin side, the admin will be able to add services, timings etc. and the other users shall be able to see these services.


<h2>Connecting to the Backend Repository </h2>

1. Follow the setup steps as mentioned in the readme of the backend repo : https://github.com/adityabisht02/BetterPoll-Backend.
2. You should be able to make requests to the locally running server from the emulator (use the ip :"http://10.0.2.2:3000/" to access the server from the emulator).


<h2>App Flow </h2>
<h4> User Side </h4>
1. The user will need to login once ,only if the admin has created this user will he be able to login. <br>
2. On logging in the user will be remembered using SharedPreferences, the user id will be saved locally as well. <br>
3. The user can now interct with the app, he can view the mess menu(updates automatically), he can interact with other users, and he can view available shuttles for booking. All of these are fetched from the backend. <br>
4. The user can use his mess code to log his attendance at the mess.

<h4> Admin Side </h4>
1. The admin can create new users who can access the app.<br>
2. The admin can add new shuttles,edit the mess menu.<br>
3. The admin can also verify users using their user code.<br>

<h2> The User Side of the application : </h2>
The User side of the application is what the students(assuming a college campus) will see and interact with.

![image](https://user-images.githubusercontent.com/89146189/193855246-7c7c972b-42df-4b8b-8139-30531563f3a1.png)    ![image](https://user-images.githubusercontent.com/89146189/193855373-932be07c-97dd-44b3-a47b-5432589b1147.png)


![image](https://user-images.githubusercontent.com/89146189/193784532-11302b38-9355-4959-8cd7-7648b9760141.png)

<h2> The Admin Side of the application </h2>
The admin will be able to add shuttles, add new users and monitor mess attendance and menu.

![image](https://user-images.githubusercontent.com/89146189/200525396-c9c7d566-35d2-4992-8062-be9da8ad2e37.png)


![image](https://user-images.githubusercontent.com/89146189/200525174-4184a7ea-077b-4d61-8ba6-1d1333f261cc.png)     ![image](https://user-images.githubusercontent.com/89146189/200525255-9a1b3236-ea4e-4621-9288-85718ebc924d.png)


## 😄[CONTRIBUTING GUIDELINES](https://github.com/MohammadKaif1/BetterPoll-Android/blob/readme/CONTRIBUTING.md)





