<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<style type="text/css">
.profile-img img{
    width: 70%;
    height: 100%;
}
.profile-img .file {
    position: relative;
    overflow: hidden;
    margin-top: -20%;
    width: 70%;
    border: none;
    border-radius: 0;
    font-size: 15px;
    background: #212529b8;
}
.profile-img .file input {
    position: absolute;
    opacity: 0;
    right: 0;
    top: 0;
}
.profile-edit-btn{
    border: none;
    border-radius: 1.5rem;
    width: 70%;
    padding: 2%;
    font-weight: 600;
    color: #6c757d;
    cursor: pointer;
}
</style>

<title>Profil</title>
</head>
<body>
<%@include  file="index.jsp" %>

<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS52y5aInsxSm31CvHOFHWujqUx_wWTS9iM6s7BAm21oEN_RiGoog" alt=""/>
                            <div class="file btn btn-lg btn-primary">
                                Change Photo
                                <input type="file" name="file" />
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        <% if(v.getGenre()==1){out.print("Mme. ");}else{out.print("M. ");} %>${current_user.getNom()} ${current_user.getPrenom()}
                                    </h5>
                                    <h6>
                                        Date aniverssaire : ${current_user.getDate()}
                                    </h6>
                                    
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">About</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <a href="ProfilEditeur.jsp">Modifer Profil</a>
                        <a href="PasswordEditeur.jsp">Modifer Mot De Passe</a>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-8">
                        <div class="tab-content " id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                               <div class="row">
                                   <div class="col-md-6">
                                       <label>Nom d'utilisateur</label>
                                   </div>
                                   <div class="col-md-6">
                                       <p>${current_user.getLogin()}</p>
                                   </div>
                               </div>
                               <div class="row">
                                   <div class="col-md-6">
                                       <label>Mail</label>
                                   </div>
                                   <div class="col-md-6">
                                       <p>${current_user.getMail()}</p>
                                   </div>
                               </div>
                               <div class="row">
                                   <div class="col-md-6">
                                       <label>Adresse</label>
                                   </div>
                                   <div class="col-md-6">
                                       <p>${current_user.getAdresse()}</p>
                                   </div>
                               </div>
                               <div class="row">
                                   <div class="col-md-6">
                                       <label>Pays</label>
                                   </div>
                                   <div class="col-md-6">
                                       <p>${current_user.getPays()}</p>
                                   </div>
                               </div>
                               <div class="row">
                                   <div class="col-md-6">
                                       <label>Ville</label>
                                   </div>
                                   <div class="col-md-6">
                                       <p>${current_user.getVille()}</p>
                                   </div>
                               </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>

</body>
</html>