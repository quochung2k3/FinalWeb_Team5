<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<style>
    .form-gap {
        padding-top: 40px;
    }
</style>
<div class="form-gap"></div>
<div class="container">
    <div style="font-size: 20px" class="row">
        <div class="">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="text-center">
                        <h3 style="margin-bottom: 20px;"><i class="fa fa-lock fa-4x"></i></h3>
                        <h2 class="text-center">Forgot Password?</h2>
                        <p>You can reset your password here.</p>
                        <div class="panel-body">

                            <form id="register-form" role="form" autocomplete="off" class="form" method="post">

                                <div class="form-group">
                                    <div style="margin: 0 auto; width: 20%; height: 40px;" class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope color-blue"></i></span>
                                        <input style="font-size: 14px;" id="email" name="email" placeholder="email address" class="form-control"  type="email">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input style="margin-bottom: 20px; margin-top: 10px;" name="recover-submit" class="btn btn-lg btn-primary btn-block" value="Reset Password" type="submit">
                                </div>

                                <input type="hidden" class="hide" name="token" id="token" value="">
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>