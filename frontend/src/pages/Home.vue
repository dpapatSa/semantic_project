<template>
  <div>
    <div class="row" >
      <div class="col-lg-6">
        <card>
          <h3 class="card-title" style="color: lightgreen">
            <i class="tim-icons icon-vector text-primary"></i>
            Welcome to Semantic Web Project
          </h3>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <h3 class="card-title" style="color: orange">
            <i class="tim-icons icon-heart-2 text-primary"></i>
            Project for HMU MSc Winter Semester 2020
          </h3>
        </card>
      </div>
      <div class="col-lg-12">
        <card>
          <h3 class="card-title" style="color: red">
            <i class="tim-icons icon-user-run text-primary"></i>
            Delta team
          </h3>
        </card>
      </div>

      <div class="col-lg-6">
        <card>
          <div >
            <div style="font-size: 20px;color: orange" >
              <i class="tim-icons icon-tablet-2 text-primary"></i> 
              Web / Visualization:
            </div>  
            <br />
            <h4>Nikolaos Astyrakakis</h4>
            <h4>Stylianos Klados</h4>
            <br />
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <div>
            <div style="font-size: 20px;color: orange">
              <i class="tim-icons icon-chart-pie-36 text-primary"></i> 
              Statistics / Pitfalls:
            </div> 
            <br />
            <h4>Dimitra Papatsarouxa</h4>
            <h4>Iraklis Skepasianos</h4>
            <br />
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <div>
            <div style="font-size: 20px;color: orange">
              <i class="tim-icons icon-chart-bar-32 text-primary"></i> 
              Metrics:
            </div>  
            <br />
            <h4>Tasos Koumarelis</h4>
            <h4>Manwlis Kritikakis</h4>
            <h4>Kuriakos Kalkanis</h4>
            <br />
          </div>
        </card>
      </div>
    </div>
  </div>
</template>



<script>
import Card from "@/components/Cards/Card"; 

export default {
  components: {
    Card,
  },
  data() {
    return {};
  },
  methods: {},
  mounted() {
    this.i18n = this.$i18n;
  },
  async created() {},
  beforeDestroy() {},
};
</script>
<style>
</style>
