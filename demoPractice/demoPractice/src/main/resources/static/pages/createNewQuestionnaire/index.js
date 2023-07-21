onload = () => {
  $('#headerUsername').text($util.getItem('userInfo').username)
  $('#headerDivB').text('创建调查问卷')

  $('#startTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
  $('#endTime').datetimepicker({
    language: 'zh-CN', // 显示中文
    format: 'yyyy-mm-dd', // 显示格式
    minView: "month", // 设置只显示到月份
    initialDate: new Date(), // 初始化当前日期
    autoclose: true, // 选中自动关闭
    todayBtn: true // 显示今日按钮
  })
}

const handleCreateQuestionnaire = () => {
  let params = {
    questionnaireName: $('#surveyName').val(),
    projectContent: $('#surveyDescription').val(),
    startTime: $('#startDate').val() && new Date($('#startDate').val()).getTime(),
    endTime: $('#endDate').val() && new Date($('#endDate').val()).getTime(),
    surveyObject: localStorage.getItem("type"),
    projectId: localStorage.getItem("projectId")
  }
  console.log(params)
  if (!params.questionnaireName) return alert('调查名不能为空！')
  if (!params.projectContent) return alert('说明不能为空！')
  // if (!params.startTime) return alert('开始时间不能为空！')
  // if (!params.endTime) return alert('结束时间不能为空！')
  $.ajax({
    url: API_BASE_URL + '/questionnaire/insert',
    type: 'POST',
    data: JSON.stringify(params),
    dataType: 'json',
    contentType: 'application/json',
    success(res) {
      if (res.code === "666") {
        localStorage.setItem("questionnaireId", res.data)
        location.href = '/pages/designQuestionnaire/index.html'
      } else {
        alert("创建失败")
      }
    }
  })
}
