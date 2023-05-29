<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<br>
<br>
<a href="/spct/index" style="padding-left: 20px; color: green; font-size: 35px;"><i class="fa-solid fa-backward"></i></a>
<br>
<br>
<form class="d-flex" role="search" method="POST" action="/nhan-vien/search" style="padding-top: 20px">
    <div class="col-md-2"></div>
    <div class="col-md-6">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
    </div>
    <div class="col-md-4" style="padding-left: 10px;padding-top: 10px;">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </div>
</form>
<form method="POST" class="col-md-10" action="/spct/update">
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Sản Phẩm</label>
            <select class="form-select" aria-label="Default select example" name="cv">
                <option selected>Open this select menu</option>
                <c:forEach items="${listSP}" var="sp">
                    <option value="${sp.id}" ${spct.sp.id==sp.id ? "selected":""}>${sp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-6">
            <label>Nhà Sản Xuất</label>
            <select class="form-select" aria-label="Default select example" name="cv">
                <option selected>Open this select menu</option>
                <c:forEach items="${listNSX}" var="nsx">
                    <option value="${nsx.id}" ${spct.nsx.id == nsx.id ? "selected":""}>${nsx.ten}</option>
                </c:forEach>
            </select>
        </div>
    </div>
    <div class="row" style="display: flex; justify-content: center; align-items: center;">
        <div class="col-md-6">
            <label>Màu Sắc</label>
            <select class="form-select" aria-label="Default select example" name="cv">
                <option selected>Open this select menu</option>
                <c:forEach items="${listMS}" var="ms">
                    <option value="${ms.id}" ${spct.ms.id == ms.id ? "selected":""}>${ms.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="col-md-6">
            <label>Dòng Sản Phẩm</label>
            <select class="form-select" aria-label="Default select example" name="cv">
                <option selected>Open this select menu</option>
                <c:forEach items="${listDSP}" var="dsp">
                    <option value="${dsp.id}" ${spct.dsp.id == dsp.id ? "selected":""}>${dsp.ten}</option>
                </c:forEach>
            </select>
        </div>
        <div class="row" style="display: flex; justify-content: center; align-items: center;">
            <div class="col-md-6">
                <label>Năm Bảo Hành</label>
                <input type="text" class="form-control" placeholder="Năm Bảo Hành" name="namBH" value="${spct.namBH}">
            </div>
            <div class="col-md-6">
                <label>Mô Tả</label>
                <input type="text" class="form-control" placeholder="Tên" name="moTa" value="${spct.moTa}">
            </div>
        </div>
        <div class="row" style="display: flex; justify-content: center; align-items: center;">
            <div class="col-md-6">
                <label>Giá Nhập</label>
                <input type="text" class="form-control" placeholder="Giá Nhập" name="giaNhap" value="${spct.giaNhap}">
            </div>
            <div class="col-md-6">
                <label>Giá Bán</label>
                <input type="text" class="form-control" placeholder="Giá Bán" name="giaBan" value="${spct.giaBan}">
            </div>
        </div>
        <div class="row" style="display: flex; justify-content: center; align-items: center;">
            <div class="col-md-6">
                <label>Số Lượng Tồn</label>
                <input type="text" class="form-control" placeholder="Số Lượng Tồn" name="slt" value="${spct.slt}">
            </div>
            <div class="col-md-6" style="padding-top: 30px;">
                <button class="btn btn-success">Update</button>
            </div>
        </div>
    </div>
</form>