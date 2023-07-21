new Vue({
    el: '#app',
    data: function (){
        return{
            questionnaireName: localStorage.getItem("questionnaireName"),
            questionData: [],
            answerData: [],
            tableData: []
        }
    },
    async mounted(){
        await this.getQuestionList()
        await this.getAnswerList()
        let infoData = []

        this.questionData.forEach((value, index) => {
            let questionOption = JSON.parse(value.questionOption)
            let count = 0
            this.answerData.forEach((value1, index1) => {
                let answer = JSON.parse(value1.answer)
                for (let i = 0; i < answer.length; i++) {
                    if (answer[i].questionId === value.id){
                        count++
                    }
                }

            })
            infoData.push({questionId: value.id, count, questionName: value.questionName, questionOption})
        })
        this.tableData = infoData
        console.log(infoData)
    },
    methods: {
        async getQuestionList(){
            let params = {
                questionnaireId: localStorage.getItem("questionnaireId")
            }
            let res = await fetch('/question/list', {method: 'POST', body: JSON.stringify(params),
                headers: {"Content-Type": "application/json"}}).then(e =>{
                return e.json()
            })
            this.questionData = res.data
        },
        async getAnswerList(){
            let params = {
                questionnaireId: localStorage.getItem("questionnaireId")
            }
            let res = await fetch('/answer/list', {method: 'POST', body: JSON.stringify(params),
                headers: {"Content-Type": "application/json"}}).then(e =>{
                return e.json()
            })
            this.answerData = res.data
        },
        handleClickBack(){
            history.back()

        }
    }
})