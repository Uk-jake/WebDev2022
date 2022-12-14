# MLOPs란 무엇인가??
  최근 실시간 보이스피싱 위험도를 제공하는 API서버를 제작하는 프로젝트를 하면서 MachineLearning에 관심이 깊졌다.
 이번 포스팅에는 MLOps가 무엇인지와 MLOps Enginner가 하는 일에 대해서 포스팅 할 것이다.

## MLOps란?
MLOps란 ML(MachineLearning) + Ops(Operations)가 합쳐진 단어로, 머신러닝을 실제로 운영할 때 생기는 일을 다루는 분야 또는 연구가 아닌 서비스(웹, 앱등)에 적용하는 과정에서 필요한 분야이다.
이러한 분야에서 작업하는 분들을 engineer라고 지칭한다. 아래 그림은 MLOps에서 다루는 AI Cycle에 대한 사진이다.  

 ![AIcycle](https://miro.medium.com/max/720/1*0GvwloHG_uD1idOUiiIaoQ.webp)

AI LifeCycle은 그게 데이터를 다루는 과정인 Data Collection, Data Ingestion, Data Analysis & Curation, Data Labeling, Data Validation, Data Preparation과
모델을 학습 시키는 Model Traning, Model Evalution, ML System Validation, ML System Deployment로 나누어져있다.

MLOps란 단순히 ML 모델뿐만 아니라, 데이터를 수집하고 분석하는 단계(Data Collection, Ingestion, Analysis, Labeling, Validation, Preparation),  
그리고 ML 모델을 학습하고 배포하는 단계(Model Training, Validation, Deployment)까지 전 과정을 AI Lifecycle로 보고, MLOps의 대상으로 보고 있다.
ML에 기여하는 Engineer들(Data Scientist, Data Engineer, SW Engineer)이 이 Lifecycle을 관리하고 모니터링해야 한다.  

## ML시스템의 요소
 머신러닝 시스템을 프로덕션 환경에 적용하고 운영하기 위해서는 단순히 좋은 머신러닝 모델만으로 가능한것이 아니다. 머신러닝 모델이 ML시스템의 핵심이기는 하지만,
 전체 프로뎐션 ML시스템의 운영을 고려하면 모델 학습 자체는 오히려 작은 부분을 차지한다고 이야기한다. 모델을 운영하기 위해서는 기반 데이터 인프라를 포함한 모든 시스템이 유기적으로 돌아가야한다.

![SystemSource](https://miro.medium.com/max/720/1*CMIuQekGd-AWelL1BuXRCg.webp)
 위 그림은 ML시스템의 운영을 위해 DevOps의 원칙을 적용한 MLOps이다.

## Data science Step for ML
1. Data Extraction(데이터 추출) - 데이터 소스에서 관련 데이터 추출
2. Data Analysis(데이터 분석) - 데이터의 이해를 위한 탐사적 데이터 분석(EDA) 수행, 모델에 필요한 데이터 스키마 및 특성 이해
3. Data Preparation(데이터 준비) - 데이터의 학습, 검증, 테스트 세트 분할
4. Model Training(모델 학습) - 다양한 알고리즘 구현, 하이퍼 파라미터 조정 및 적용, output은 학습된 모델.
5. Model Evaluation(모델 평가) - holdout test set에서 모델을 평가, output은 모델의 성과 평가 metric.
6. Model Validation(모델 검증) - 기준치 이상의 모델 성능이 검증되고, 배포에 적합한 수준인지 검증
7. Model Serving(모델 서빙)
- 온라인 예측을 제공하기 위해 REST API가 포함된 마이크로 서비스
- 배치 예측 시스템
- 모바일 서비스의 embedded 모델
8. Model Monitoring(모델 모니터링) - 모델의 예측 성능을 모니터링
