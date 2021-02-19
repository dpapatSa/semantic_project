<template>
  <footer class="footer">
    <div class="container-fluid"> 
      <div class="copyright">
        Made by Nikolaos Astyrakakis for Delta Team of Semantic Web. Using VueJS Black Dashboard. © {{year}}  
         </div>
    </div>
  </footer>
</template>
<script>
  export default {
    data() {
      return {
        year: new Date().getFullYear()
      }
    }
  };
</script>
<style>
</style>
