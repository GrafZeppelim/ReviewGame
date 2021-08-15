

<%@page import="ObjecInfo.Account"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.AccountModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AccountModel am = new AccountModel();

    ArrayList<Account> listAc = am.loadAccount();

%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Sign Up</title>
        <link rel = "icon" href = "imagesSignUp/logoGroup.png" type = "image/x-icon"> 

        <!-- Font Icon -->
        <link rel="stylesheet" href="fontsSignUp/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="cssSignUp/style.css">
        <style>
            body{
                background-image:  url('imagesSignUp/signUp.jpg') !important;
            }
        </style>
    </head>
    <body>

        <div class="main">

            <section class="signup">
                <!--<img src="images/signup-bg.jpg" alt="">--> 
                <div class="container">
                    <div class="signup-content">
                        <form method="POST" id="signup-form" class="signup-form" action="Client" enctype="multipart/form-data" onsubmit="return checkPassword(this)">
                            <h2 class="form-title">Create account</h2>
                            <div class="form-group">
                                <input type="text" class="form-input" name="account" id="name" placeholder="Your Account" required/>

                            </div> 
                            <div class="form-group">
                                <input type="password" class="form-input" name="password" id="password" placeholder="Password" required/>
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-input" name="re_password" id="re-password" placeholder="Re-password" required/><span id='message'></span>
                            </div>
                            <div class="form-group">
                                <input type="text" class="form-input" name="fullname" id="name" placeholder="Your Name" required/>
                            </div> 
                            <div class="form-group">
                                <input type="email" class="form-input" name="email" id="email" placeholder="Your Email" required/>
                            </div>

                            <div class="form-group">
                                <input type="tel" class="form-input" name="phone" id="phone" placeholder="Your Phone" required/>
                            </div>
                            <div class="form-group">
                                <input type="radio" name="gender" value="0" checked> Male<br>
                                <input type="radio" name="gender" value="1"> Female<br>
                                <input type="radio" name="gender" value="2"> Other
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term"/>
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group">
                                <input type="submit" name="submit" id="submit" class="form-submit" value="Sign up" disabled/>
                            </div>
                        </form>
                        <p class="loginhere">
                            Have already an account ? <a href="#" class="loginhere-link">Login here</a>
                        </p>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="vendorSignUp/jquery/jquery.min.js"></script>
        <script src="jsSignUp/main.js"></script>
        <script>
                                    $('#password, #re-password').on('keyup', function () {
                                        if ($('#password').val() == $('#re-password').val()) {
                                            $('#message').html('Matching').css('color', 'green');
                                        } else
                                            $('#message').html('Not Matching').css('color', 'red');
                                    });

//            function myFunction() {
//                if(document.getElementById("password") == document.getElementById("re-password"))
//                document.getElementById("submit").disabled = false;
//            else
//                document.getElementById("submit").disabled = true;
//            }
//            
                                    function checkPassword(form) {
                                        password = form.password.value;
                                        re_password = form.re_password.value;
                                        // If password not entered 
                                        if (password == '')
                                            alert("Please enter Password");

                                        // If confirm password not entered 
                                        else if (re_password == '')
                                            alert("Please enter confirm password");

                                        // If Not same return False.     
                                        else if (password != re_password) {
                                            alert("\nPassword did not match: Please try again...")
                                            return false;
                                        }
                                        // If same return True. 
                                        else {
                                            return true;
                                        }

                                    }

                                    var checker = document.getElementById('agree-term');
                                    var sendbtn = document.getElementById('submit');
                                    checker.onchange = function () {
                                        sendbtn.disabled = !this.checked;
                                    };
        </script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
