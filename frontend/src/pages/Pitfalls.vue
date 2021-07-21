<template>
  <div>
    <div class="row" v-if="!show">
      <card type="chart"> <h4>Please Wait Loading...</h4></card>
    </div>
    <div class="row" v-if="show">
      <div class="col-lg-12">
        <card type="chart" style="color: lightgrey">
          <ul>
            In the pie charts below you can see the number of pitfall cases for
            each ontology, in slices.
            <br />
            Specifically:
            <br />
            - Missing Annotations
            <br />
            - Unconnected Ontologies
          </ul>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">bfo</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              style="height: 100%"
              chart-id="purple-bar-chart"
              :extra-options="barChart.extraOptions"
              :chart-data="barChart.bfo_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Friend of a friend (FOAF)</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.foaf_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Dublincore</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.dublincore_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">Cidoc</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.cidoc_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
      <div class="col-lg-6">
        <card>
          <template slot="header">
            <h3 class="card-title">obi</h3>
          </template>
          <div class="chart-area">
            <bar-chart
              chart-id="purple-bar-chart"
              :chart-data="barChart.obi_data_chart"
            >
            </bar-chart>
          </div>
        </card>
      </div>
    </div>
  </div>
</template>



<script>
import LineChart from "@/components/Charts/LineChart";
import BarChart from "@/components/Charts/BarChart"; 
import Card from "@/components/Cards/Card";

import * as chartConfigs from "@/components/Charts/config";
import config from "@/config";
import axios from "axios";

let bfo_data = [];
let foaf_data = [];
let cidoc_data = [];
let dublincore_data = [];
let obi_data = [];

export default {
  components: {
    LineChart,
    BarChart, 
    Card,
  },
  data() {
    return {
      show: false,
      barChart: {
        type: "pie",
        bfo_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "bfo",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: bfo_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        foaf_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Foaf",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: foaf_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        cidoc_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Cidoc",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: cidoc_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        dublincore_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "Dublincore",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: dublincore_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
        obi_data_chart: {
          extraOptions: chartConfigs.barChartOptions,
          labels: ["MissingAnnotations", "UnconnectedOntology"],
          datasets: [
            {
              label: "OBI",
              fill: true,
              borderColor: config.colors.danger,
              borderWidth: 2,
              borderDash: [],
              borderDashOffset: 0.0,
              data: obi_data,
            },
          ],
          gradientColors: config.colors.primaryGradient,
          gradientStops: [1, 0.4, 0],
        },
      },
    };
  },
  created() {
    this.show = false;
    axios
      .get(
        "http://"+(process.env.VUE_APP_BACKEND_HOST || "localhost" )+":"+(process.env.VUE_APP_BACKEND_PORT || "9090" )+"/Project_Final/webresources/bfo/pitfalls"
      )
      .then((result) => {
        bfo_data.push(result.data.MissingAnnotations);
        bfo_data.push(result.data.UnconnectedOntology);
        axios
          .get("http://"+(process.env.VUE_APP_BACKEND_HOST || "localhost" )+":"+(process.env.VUE_APP_BACKEND_PORT || "9090" )+"/Project_Final/webresources/foaf/pitfalls")
          .then((result) => {
            foaf_data.push(result.data.MissingAnnotations);
            foaf_data.push(result.data.UnconnectedOntology);
            axios
              .get(
                "http://"+(process.env.VUE_APP_BACKEND_HOST || "localhost" )+":"+(process.env.VUE_APP_BACKEND_PORT || "9090" )+"/Project_Final/webresources/cidoc/pitfalls"
              )
              .then((result) => {
                cidoc_data.push(result.data.MissingAnnotations);
                cidoc_data.push(result.data.UnconnectedOntology);
                axios
                  .get(
                    "http://"+(process.env.VUE_APP_BACKEND_HOST || "localhost" )+":"+(process.env.VUE_APP_BACKEND_PORT || "9090" )+"/Project_Final/webresources/dublincore/pitfalls"
                  )
                  .then((result) => {
                    dublincore_data.push(result.data.MissingAnnotations);
                    dublincore_data.push(result.data.UnconnectedOntology);

                    axios
                      .get(
                        "http://"+(process.env.VUE_APP_BACKEND_HOST || "localhost" )+":"+(process.env.VUE_APP_BACKEND_PORT || "9090" )+"/Project_Final/webresources/obi/pitfalls"
                      )
                      .then((result) => {
                        obi_data.push(result.data.MissingAnnotations);
                        obi_data.push(result.data.UnconnectedOntology);
                        this.show = true;
                      });
                  });
              });
          });
      });
  },
};
</script>

<style>
</style>
