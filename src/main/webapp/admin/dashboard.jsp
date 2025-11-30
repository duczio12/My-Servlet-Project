<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="./layout/header.jsp" %>
<%@ include file="./layout/sidebar.jsp" %>

<div class="container-fluid px-4">
    <h1 class="mt-4">Dashboard Tổng Quan</h1>
    
    <div class="row">
        <div class="col-xl-3 col-md-6">
            <div class="card bg-primary text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">NHÂN VIÊN</div>
                            <div class="h4">46</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-users fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/employee">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
        
        <div class="col-xl-3 col-md-6">
            <div class="card bg-success text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">PHÒNG BAN</div>
                            <div class="h4">8</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-building fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/departments">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
        
        <!-- Chấm công -->
        <div class="col-xl-3 col-md-6">
            <div class="card bg-warning text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">CHẤM CÔNG</div>
                            <div class="h4">18</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-clock fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/attendance">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
        
        <!-- Lương -->
        <div class="col-xl-3 col-md-6">
            <div class="card bg-danger text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">LƯƠNG</div>
                            <div class="h4">35</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-wallet fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/salary">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
        
        <!-- Nghỉ phép -->
        <div class="col-xl-3 col-md-6">
            <div class="card bg-info text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">NGHỈ PHÉP</div>
                            <div class="h4">15</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-calendar-day fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/leave">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
        
        <!-- Hợp đồng -->
        <div class="col-xl-3 col-md-6">
            <div class="card bg-secondary text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">HỢP ĐỒNG</div>
                            <div class="h4">45</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-file-alt fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/contract">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
        
        <!-- Thưởng/Phạt -->
        <div class="col-xl-3 col-md-6">
            <div class="card bg-dark text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">THƯỞNG / PHẠT</div>
                            <div class="h4">28</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-award fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/reward">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
        
        <!-- Tài khoản -->
        <div class="col-xl-3 col-md-6">
            <div class="card bg-purple text-white mb-4">
                <div class="card-body">
                    <div class="d-flex justify-content-between">
                        <div>
                            <div class="small">TÀI KHOẢN</div>
                            <div class="h4">40</div>
                        </div>
                        <div class="align-self-center">
                            <i class="fas fa-user-cog fa-2x"></i>
                        </div>
                    </div>
                </div>
                <div class="card-footer d-flex align-items-center justify-content-between">
                    <a class="small text-white stretched-link" href="${pageContext.request.contextPath}/admin/account">Xem chi tiết</a>
                    <div class="small text-white"><i class="fas fa-angle-right"></i></div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-xl-6">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-clock me-1"></i>
                    Đơn nghỉ phép chờ duyệt
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTableLeave" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Loại nghỉ</th>
                                    <th>Trạng thái</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>31</td>
                                    <td>Bệnh</td>
                                    <td><span class="badge bg-warning text-dark">💬 Chờ phê duyệt</span></td>
                                </tr>
                                <tr>
                                    <td>33</td>
                                    <td>Khác</td>
                                    <td><span class="badge bg-warning text-dark">💬 Chờ phê duyệt</span></td>
                                </tr>
                                <tr>
                                    <td>35</td>
                                    <td>Phép</td>
                                    <td><span class="badge bg-warning text-dark">💬 Chờ phê duyệt</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="mt-3 text-end">
                        <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/admin/leave">
                            Xem thêm
                            <i class="fas fa-arrow-right ms-1"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
        
        <!-- Hợp đồng hết hạn -->
        <div class="col-xl-6">
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-exclamation-triangle me-1"></i>
                    Hợp đồng hết hạn
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTableContract" width="100%" cellspacing="0">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Loại hợp đồng</th>
                                    <th>Ngày hết hạn</th>
                                    <th>Mã nhân viên</th>
                                    <th>Tình trạng</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>13</td>
                                    <td>Kinh Doanh</td>
                                    <td>2025-05-25</td>
                                    <td>22</td>
                                    <td><span class="badge bg-danger">Quá hạn</span></td>
                                </tr>
                                <tr>
                                    <td>14</td>
                                    <td>Thử việc</td>
                                    <td>2025-06-01</td>
                                    <td>25</td>
                                    <td><span class="badge bg-warning text-dark">Sắp hết hạn</span></td>
                                </tr>
                                <tr>
                                    <td>15</td>
                                    <td>Chính thức</td>
                                    <td>2025-04-20</td>
                                    <td>30</td>
                                    <td><span class="badge bg-danger">Quá hạn</span></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="mt-3 text-end">
                        <a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/admin/contract">
                            Xem thêm
                            <i class="fas fa-arrow-right ms-1"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<style>
.bg-purple {
    background-color: #6f42c1 !important;
}
</style>

<script>
document.addEventListener('DOMContentLoaded', function() {
    if (typeof simpleDatatables !== 'undefined') {
        new simpleDatatables.DataTable("#dataTableLeave", {
            searchable: true,
            fixedHeight: true,
            perPage: 5
        });
        new simpleDatatables.DataTable("#dataTableContract", {
            searchable: true,
            fixedHeight: true,
            perPage: 5
        });
    }
});
</script>

<%@ include file="./layout/footer.jsp" %>