# 🚀 AI-Powered Vibe Coding SaaS Platform

> ⚠️ **Note: This project is actively under development and not yet complete.**

A full-stack AI-powered SaaS platform inspired by [Lovable](https://lovable.dev) and [Replit](https://replit.com) — where users can generate, edit, preview, and deploy web applications using AI, right from the browser.

This repository documents the **complete architectural journey** of the platform — from a **Monolith** to a **Microservices** architecture — built using Java, Spring Boot, Spring AI, React, Docker, Kubernetes, and more.

---

## 📁 Repository Structure

```
AI-Powered-Vibe-Coding-SaaS-Platform/
│
├── 📦 AI-Based-Vibe-Coding-Platform/          # Monolith Backend (Spring Boot)
│
├── 🎨 AI-Basaed-Vibe-Coding-Platform-Frontend/
│   └── project-companion/                      # React + TypeScript Frontend
│
├── 🔧 Microservices-Lovable-Clone/             # Microservices Backend (Work in Progress)
│   ├── account-service/                        # Auth, Users & Billing
│   ├── workspace-service/                      # Projects & File Management
│   ├── intelligence-service/                   # AI Code Generation
│   ├── api-gateway/                            # API Gateway (Spring Cloud Gateway)
│   ├── discovery-service/                      # Service Registry (Eureka)
│   ├── config-service/                         # Centralized Configuration
│   └── common-library/                         # Shared DTOs, Security & Utilities
│
└── 🧰 project-starters/
    └── react-vite-tailwind-daisyui-starter/    # Frontend Starter Template
```

---

## 🏗️ Architecture Overview

### Phase 1 — Monolith (`AI-Based-Vibe-Coding-Platform`)

The starting point of this project. A single Spring Boot application that handles everything — authentication, project management, AI code generation, billing, deployments, and file storage.

**Key highlights:**
- JWT-based authentication & role-based access control
- AI code generation via **Spring AI** (OpenAI integration)
- Real-time streaming chat with **SSE (Server-Sent Events)**
- **Stripe** integration for subscription billing
- **MinIO** for S3-compatible file storage
- **Kubernetes** deployment support for user project sandboxes
- Redis for caching

---

### Phase 2 — Microservices (`Microservices-Lovable-Clone`)

The platform is being re-architected into independent, scalable microservices. Each service owns its own database and can be deployed, scaled, and maintained independently.

| Service | Responsibility |
|---|---|
| `api-gateway` | Single entry point, routing, JWT validation |
| `discovery-service` | Service registry using Netflix Eureka |
| `config-service` | Centralized config management |
| `account-service` | User auth, profiles, subscriptions, Stripe billing |
| `workspace-service` | Project creation, file management, deployments |
| `intelligence-service` | AI chat, code generation via Spring AI |
| `common-library` | Shared security filters, DTOs, exception handling |

---

### Frontend (`AI-Basaed-Vibe-Coding-Platform-Frontend`)

A modern React + TypeScript frontend for interacting with the platform.

**Key highlights:**
- Built with **React**, **TypeScript**, **Vite**, **Tailwind CSS**
- Real-time AI chat panel with streaming support
- Code editor with file tree navigation
- Project dashboard and live preview panel
- shadcn/ui component library

---

## 🛠️ Tech Stack

| Layer | Technologies |
|---|---|
| **Backend** | Java 21, Spring Boot 3, Spring AI, Spring Security, Spring Cloud |
| **Frontend** | React 18, TypeScript, Vite, Tailwind CSS, shadcn/ui |
| **Database** | PostgreSQL, Redis |
| **AI** | OpenAI (via Spring AI) |
| **Payments** | Stripe |
| **Storage** | MinIO (S3-compatible) |
| **Containerization** | Docker, Docker Compose |
| **Orchestration** | Kubernetes (K8s) |
| **Service Discovery** | Netflix Eureka |
| **API Gateway** | Spring Cloud Gateway |
| **Config Management** | Spring Cloud Config Server |

---

## 🚦 Getting Started

### Prerequisites

Make sure you have the following installed:
- Java 21+
- Maven 3.8+
- Node.js 18+ and npm
- Docker & Docker Compose
- (Optional) Kubernetes cluster for full deployment

---

### ▶️ Running the Monolith

```bash
# 1. Navigate to the monolith folder
cd AI-Based-Vibe-Coding-Platform

# 2. Configure your environment in application.yaml
#    (Set DB, Redis, OpenAI, Stripe, MinIO credentials)

# 3. Start dependencies via Docker Compose
docker-compose -f services.docker-compose.yml up -d

# 4. Run the Spring Boot app
./mvnw spring-boot:run
```

---

### ▶️ Running the Microservices

```bash
# Start each service in this order:

# 1. Config Service
cd Microservices-Lovable-Clone/config-service
./mvnw spring-boot:run

# 2. Discovery Service (Eureka)
cd ../discovery-service
./mvnw spring-boot:run

# 3. Account Service
cd ../account-service
./mvnw spring-boot:run

# 4. Workspace Service
cd ../workspace-service
./mvnw spring-boot:run

# 5. Intelligence Service
cd ../intelligence-service
./mvnw spring-boot:run

# 6. API Gateway (start last)
cd ../api-gateway
./mvnw spring-boot:run
```

---

### ▶️ Running the Frontend

```bash
cd AI-Basaed-Vibe-Coding-Platform-Frontend/project-companion

# Install dependencies
npm install

# Start the dev server
npm run dev
```

The frontend will be available at `http://localhost:5173`

---

## 📐 Key Features

- 🤖 **AI Code Generation** — Chat with AI to generate and modify your web app in real time
- 📁 **File Tree Management** — Browse, edit, and manage project files directly in the browser
- 👀 **Live Preview** — See your generated app rendered live inside the platform
- 👥 **Project Collaboration** — Invite team members with role-based permissions (Owner, Editor, Viewer)
- 💳 **Subscription Billing** — Free and paid plans managed via Stripe
- 🚀 **One-Click Deploy** — Deploy user projects to isolated Kubernetes pods
- 🔐 **Secure Auth** — JWT-based authentication with fine-grained access control

---

## 📖 Learning Goals

This project was built as part of a hands-on learning journey to understand:

- How to build a **production-grade SaaS backend** with Spring Boot
- How to integrate **AI capabilities** into a real application using Spring AI
- How to evolve an application from **Monolith → Microservices**
- How **Spring Cloud** components (Gateway, Eureka, Config Server) work together
- How to handle **payments, storage, containerization, and orchestration** in a real project

---

## 🗺️ Roadmap

- [x] Monolith backend with all core features
- [x] React frontend with AI chat and project dashboard
- [x] Microservices scaffold (account, workspace, intelligence, gateway, discovery, config)
- [ ] Kafka-based event-driven communication between services
- [ ] Complete workspace-service and intelligence-service implementations
- [ ] Kubernetes manifests for full microservices deployment
- [ ] CI/CD pipeline setup

---

## 👨‍💻 Author

**Harshil Champaneri**
Built as part of the **0 to 100 Spring Boot Cohort 4.0** program.

---

## ⭐ Support

If you find this project helpful or interesting, please consider giving it a **star ⭐** on GitHub — it means a lot!
