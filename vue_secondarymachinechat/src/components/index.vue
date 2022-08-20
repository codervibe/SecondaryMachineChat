<template>
  <div>
    <input type="text" v-model="chat.question" id="send">
    <input type="button" @click="actionsChat" id="put" value="发送">
    <!--    v-model="chat.answer"-->
    <div id="Info">{{ chat.answer }}</div>
    <div>


    </div>
  </div>

</template>

<script>


export default {

  name: 'HelloWorld',
  data() {
    return {
      chat: {
        question: "",
        answer: ""
      },


    }
  },

  methods: {


    actionsChat() {
      // const message = '';

      // 检查有没有绑定好数据
      console.log(this.chat.question);
      console.log("数据提交.......")
      const url = "http://localhost:8989/machinechat/chat/answer";
      this.$http.post(url, this.chat, ).then(res => {
        if (res.status == "200") {
          // const resLength = res.data.length
          // console.log("数组长度 ",resLength);
          // console.log("11111111111111111111111111111111")
          console.log(res.data);
          // console.log(res.data[0].question);
          // console.log(res.data[resLength].answer);
          // console.log(res.data.length);
          console.log(res.data.answer);
          // this.$voice('您有新的订单，请及时处理')
          this.chat.answer = res.data.answer;
          new Audio("http://tts.youdao.com/fanyivoice?word=" + res.data.answer + "&le=zh&keyfrom=speaker-target&voice=1").play();
          // new Audio("http://localhost:8989/machinechat/stream/mp3?path=1").play()
          // this.message = res.data.answer;
          // Audio("http://localhost:8989/machinechat/stream/mp3?message="+message).play()
        }
      })
    },

  },
  components: {}
  ,
  created() {
    console.log("页面创建~~~~")


  }
  ,
  watch: {
    $route: {
      handler: function (path, oldpath) {
        console.log(oldpath);
        console.log(path);
        console.log("由" + oldpath.path + "转换为新的路径" + path.path);
        // if (path.path == "/user") {
        //   this.findAll()
        // }
      }
      ,
      //深度观察监听
      deep: true
    }
  }

}


</script>


