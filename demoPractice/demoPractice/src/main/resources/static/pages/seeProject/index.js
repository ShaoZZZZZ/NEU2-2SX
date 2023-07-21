
const getQuestionnaireInfo = async (id) =>{
  let params = {
  projectId: id
}
  let res = await fetch(API_BASE_URL + '/questionnaire/list' ,
      {method: 'POST', body: JSON.stringify(params),
        headers: {"Content-Type": "application/json"}}).then(res =>{
          return res.json()
  })
      let info = res.data
      info.map((value, index) => {
        $("#questionnaireTable").append(`
        <tr>
            <td>${index + 1}</td>
            <td>${value.questionnaireName}</td>
            <td>${value.startTime}</td>
            <td>
            <button type="button" class="btn btn-link" onclick="handleReleaseQuestionnaire('${id}')">发布</button>
            <button type="button" class="btn btn-link">关闭</button>
            <button type="button" class="btn btn-link btn-red" onclick="handleClickLink('${value.id}')">链接</button>
            <button type="button" class="btn btn-link btn-red" onclick="handleClickStatistic('${value.id}', '${value.questionnaireName}')">统计</button>
          </td>
        </tr>`)
      })
}
const handleClickLink = (id) =>{
  localStorage.setItem("questionnaireId", id)
  location.href = '/pages/answerSheet/index.html'
}

const handleClickStatistic = (id, name)=>{
  localStorage.setItem("questionnaireId", id)
  localStorage.setItem("questionnaireName", name)
  location.href = '/pages/statistics/index.html'
}


const handleReleaseQuestionnaire = (id) =>{
  let params = {
    id,
    questionnaireStatus: '1'
  }
  $.ajax({
    url: API_BASE_URL + '/questionnaire/update',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      alert('发布成功')
    }
  })
}
const fetchProjectInfo = (id) => {
  let params = {
    id
  }
  $.ajax({
    url: API_BASE_URL + '/queryProjectList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let info = res.data[0]
      $('#projectName').text(info.projectName)
      $('#createTime').text(info.creationDate)
      $('#projectDescription').text(info.projectContent)
    }
  })
}


onload = async () => {
  $('#headerDivB').text('项目详情')

  let projectId = $util.getPageParam('seeProject')
  console.log(projectId, 'projectId')

  await fetchProjectInfo(projectId)
  await getQuestionnaireInfo(projectId)
}
