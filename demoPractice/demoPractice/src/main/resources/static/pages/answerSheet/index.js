let answer = []
let singleQuestions = []
let multiQuestions = []
const handleRadioChange = ()=>{

}
const getQuestionList = ()=>{
  let params = {
    questionnaireId: localStorage.getItem("questionnaireId")
  }
  $.ajax({
    url: API_BASE_URL + '/question/list',
    type: 'POST',
    data: JSON.stringify(params),
    dataType: 'json',
    contentType: 'application/json',
    success(res) {
      questionList = res.data
      questionList.map((item, index) => {
          answer.push({questionId: item.id, answer: '1'})
        switch (item.questionType){
            case '1':
              singleQuestions.push({questionId: item.id, name: 'chooseTerm'+index})
              let str=''
              JSON.parse(item.questionOption).forEach((value, index1) => {
                str += `<div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="${'chooseTerm'+index}" value="${index1}">${value.chooseTerm}
          </label>
        </div>`})
            $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">${index +1}.${item.questionName},单选题</span>
        <span class="must-answer" id="mustAnswer">${item.isMust==='true'?'必答题':'非必答题'}</span>
      </div>
      <div class="bottom" id="optionBox">
      ${str}
      </div>
    </div>`)
                break
          case '2':
              singleQuestions.push({questionId: item.id, name: 'chooseTerm'+index})
              let str1=''
              JSON.parse(item.questionOption).forEach((value, index1) => {
                  str1 += `<div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="checkbox" name="${'chooseTerm'+index}" onchange="" value="${index1}">${value.chooseTerm}
          </label>
        </div>`})
              $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">${index +1}.${item.questionName}多选题</span>
        <span class="must-answer" id="mustAnswer">${item.isMust==='true'?'必答题':'非必答题'}</span>
      </div>
      <div class="bottom">
        ${str1}
      </div>
    </div>
  `)
                break
          case '3':
            $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">${index +1}.${item.questionName},填空题</span>
        <span class="must-answer" id="mustAnswer">${item.isMust==='true'?'必答题':'非必答题'}/span>
      </div>
      <div class="bottom">
        <textarea class="form-control" placeholder="请输入" rows="4" style="width: 70%;"></textarea>
    </div>
  `)
                break
          case '4':
            $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">${index +1}.${item.questionName},矩阵题</span>
        <span class="must-answer" id="mustAnswer">${item.isMust==='true'?'必答题':'非必答题'}</span>
      </div>
      <div class="bottom">
        <table class="table">
          <thead>
            <tr>
              <th></th>
              <th>选项1</th>
              <th>选项2</th>
              <th>选项3</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>标题1</td>
              <td><input type="radio" name="chooseTerm1" /></td>
              <td><input type="radio" name="chooseTerm1" /></td>
              <td><input type="radio" name="chooseTerm1" /></td>
            </tr>
            <tr>
              <td>标题2</td>
              <td><input type="radio" name="chooseTerm2" /></td>
              <td><input type="radio" name="chooseTerm2" /></td>
              <td><input type="radio" name="chooseTerm2" /></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  `)
                break
          case '5':
            $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">${index +1}.${item.questionName},量表题</span>
        <span class="must-answer" id="mustAnswer">${item.isMust==='true'?'必答题':'非必答题'}</span>
      </div>
      <div class="bottom" style="display: flex; align-items: center; justify-content: space-between;">
        <div>很满意</div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />5
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />4
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />3
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />2
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" />1
          </label>
        </div>
        <div>很不满意</div>
      </div>
    </div>`)
                break
        }
      })
    }
  })
}
const handleSubmit = ()=>{
    singleQuestions.forEach((value, index) => {
        let selectedValue = $(`input[name= ${value.name}]:checked`).val();
        console.log(selectedValue);
        answer.forEach(value1 => {
            if (value.questionId === value1.questionId){
                value1.answer = selectedValue
            }
        })
    })
    multiQuestions.forEach(value => {
        let checkedValue = ''
        $(`input[name=${value.name}]:checkbox:checked`).each(function(){
            checkedValue+=$(this).val()
        })
        answer.forEach(value1 => {
            if (value.questionId === value1.questionId){
                value1.answer = checkedValue
            }
        })
    })



    let params = {
        roleId ,
        questionnaireId: localStorage.getItem("questionnaireId"),
        answerStatus: '1',
        answer: JSON.stringify(answer)
    }
    $.ajax({
        url: API_BASE_URL + '/answer/insert',
        type: 'POST',
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: 'application/json',
        success(res) {
            alert('提交成功')
            location.href = '/pages/questionnaire/index.html'
        }
    })

}
let roleId
onload = () => {
    roleId = $util.getItem('userInfo').id
    getQuestionList()


}
